package top.hugongzi.framework;

import com.fasterxml.jackson.databind.ObjectMapper;
import top.hugongzi.framework.annotations.*;
import top.hugongzi.framework.enums.RequestMethod;
import top.hugongzi.framework.model.Handler;
import top.hugongzi.framework.model.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.Serial;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@MultipartConfig
public class FrontController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private final Map<String, Handler> mapping = new HashMap<>();
    private String[] packages = null;
    private String viewLocation = "";
    private String suffix = ".jsp";
    private DateFormat dateFormat = null;
    private String encoding = "utf-8";

    @Override
    public void init() throws ServletException {
        this.packages = this.getInitParameter("packages").split(";");
        this.viewLocation = this.getInitParameter("view_location");
        this.suffix = this.getInitParameter("suffix");
        ResourceBundle bundle = ResourceBundle.getBundle("setting");
        String format = bundle.getString("dateFormat");
        dateFormat = new SimpleDateFormat(format);
        this.encoding = bundle.getString("encoding");
        this.scanComponent();
        this.mapping.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    private void scanComponent() {
        String classPath = Objects.requireNonNull(this.getClass().getResource("/")).getPath();
        Arrays.stream(this.packages).forEach(aPackage -> {
            String packagePath = aPackage.replace(".", "\\");
            File folder = new File(classPath + packagePath);
            if (folder.exists()) {
                String[] files = folder.list();
                if (files != null) {
                    for (String s : files) {
                        String file = s.substring(0, s.lastIndexOf("."));
                        try {
                            Class<?> clazz = Class.forName(aPackage + "." + file);
                            Annotation ann = clazz.getAnnotation(Controller.class);
                            if (ann != null) {
                                Constructor<?> constructor = clazz.getDeclaredConstructor();
                                constructor.setAccessible(true);
                                Object instance = constructor.newInstance();
                                this.processMapping(instance, clazz);
                            }
                        } catch (ClassNotFoundException | IllegalAccessException
                                 | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });
    }

    private void processMapping(Object target, Class<?> clazz) {
        RequestMapping clazzAnnotation = clazz.getAnnotation(RequestMapping.class);
        String[] parentMapping = null;
        if (clazzAnnotation != null) {
            parentMapping = clazzAnnotation.value();
        }
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
            if (methodAnnotation != null) {
                String[] childMapping = methodAnnotation.value();
                for (String s : childMapping) {
                    if (parentMapping != null) {
                        for (String string : parentMapping) {
                            if (!string.startsWith("/") || !s.startsWith("/")) {
                                throw new RuntimeException(clazz.getName() + "路径配置错误");
                            } else {
                                String path = string + s;
                                this.mappingItem(path, target, method);
                            }
                        }
                    } else {
                        if (!s.startsWith("/")) {
                            throw new RuntimeException(clazz.getName() + "路径配置错误");
                        } else {
                            this.mappingItem(s, target, method);
                        }
                    }
                }
            }
        }
    }

    private void mappingItem(String path, Object target, Method method) {
        RequestMethod[] requestMethods = method.getAnnotation(RequestMapping.class).methods();
        Handler handler = new Handler(target, method);
        if (requestMethods.length == 0) {
            if (this.mapping.get(path) != null) {
                throw new RuntimeException(method.getDeclaringClass().getName() + " " + path + "路径已经映射");
            } else {
                this.mapping.put(path, handler);
            }
        } else {
            for (RequestMethod requestMethod : requestMethods) {
                String key;
                key = requestMethod.getMethod() + path;
                if (this.mapping.get(path) != null) {
                    throw new RuntimeException(method.getDeclaringClass().getName() + " " + path + "路径已经映射");
                } else {
                    this.mapping.put(key, handler);
                }
            }
        }
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding(this.encoding);
        response.setCharacterEncoding(this.encoding);
        String URI = request.getRequestURI();
        if (URI.contains(".")) {
            URI = URI.substring(URI.indexOf(this.getServletContext().getContextPath())
                    + this.getServletContext().getContextPath().length(), URI.lastIndexOf("."));
        } else {
            URI = URI.substring(URI.indexOf(this.getServletContext().getContextPath())
                    + this.getServletContext().getContextPath().length());
        }
        System.out.println("URI:" + URI);
        String method = request.getMethod().toLowerCase();
        String key = method + URI;
        Handler handler = this.mapping.get(key);
        if (handler == null) {
            handler = this.mapping.get(URI);
        }
        try {
            if (handler == null) {
                throw new RuntimeException("请求地址错误，无法正常处理");
            } else {
                // 将请求数据提取，并按照方法参数列表顺序组织成数组
                Object[] parameterObjects = this.populateData(request, response, handler.getMethod());
                try {
                    // 执行业务逻辑方法
                    Object result = handler.getMethod().invoke(handler.getTarget(), parameterObjects);
                    // 如果处理方法标注@ResponseBody,将返回值输出为JSON格式
                    if (handler.getMethod().getAnnotation(ResponseBody.class) != null) {
                        ObjectMapper mapper = new ObjectMapper();
                        response.setContentType("application/json;charset=utf-8");
                        mapper.writeValue(response.getWriter(), result);
                    } else if (result instanceof ModelAndView mv) {
                        // 如果返回值为类型为ModelAndView，则将数据放置到reqeust属性中，并转发到相应页面
                        String view = mv.getView();
                        Map<String, Object> model = (Map<String, Object>) mv.getModel();
                        model.forEach(request::setAttribute);
                        RequestDispatcher rd = request
                                .getRequestDispatcher(this.viewLocation + "/" + view + this.suffix);
                        rd.forward(request, response);
                    } else {
                        // 返回值为字符串，用于表示要显示的视图页面，如果以redirect:开头，则以重定向的方式跳转，否则转发
                        // 如果以return:开头，则仅返回字符串
                        String page = (String) result;
                        int index = page.indexOf(":");
                        if (index > 0) {
                            String way = page.substring(0, index);
                            page = page.substring(index + 1);
                            if ("redirect".equals(way)) {
                                response.sendRedirect(page);
                            } else if ("return".equals(way)) {
                                response.getWriter().println(page);
                            } else {
                                RequestDispatcher rd = request.getRequestDispatcher(this.viewLocation + "/" + page + this.suffix);
                                rd.forward(request, response);
                            }

                        } else {
                            RequestDispatcher rd = request.getRequestDispatcher(this.viewLocation + "/" + page + this.suffix);
                            rd.forward(request, response);
                        }
                    }
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    request.setAttribute("error", e.getCause().getMessage());
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/error.jsp");
                    rd.forward(request, response);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            request.setAttribute("error", e.getCause().getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/error.jsp");
            rd.forward(request, response);
        }
    }

    private Object[] populateData(HttpServletRequest request, HttpServletResponse response, Method method) throws IOException, ServletException {
        List<Object> parameterObject = new ArrayList<>();
        Parameter[] parameters = method.getParameters();
        for (Parameter parameter : parameters) {
            RequestParam paramAnotation = parameter.getAnnotation(RequestParam.class);
            RequestHeader headerAnotation = parameter.getAnnotation(RequestHeader.class);
            String paramName = parameter.getName();
            //处理RequestParam注解出现的情况
            if (paramAnotation != null) {
                if (!"".equals(paramAnotation.name())) {
                    paramName = paramAnotation.name();
                }
            }
            String value = null;
            //处理RequestHeader出现的情况
            if (headerAnotation != null) {
                value = request.getHeader(headerAnotation.value());
            } else if (paramAnotation != null) {
                value = request.getParameter(paramName);
                if (value == null) value = paramAnotation.defaultValue();
            }
            if (parameter.getType().isAssignableFrom(HttpServletRequest.class)) {
                parameterObject.add(request);
            } else if (parameter.getType().isAssignableFrom(HttpServletResponse.class)) {
                parameterObject.add(response);
            } else if (parameter.getType().isAssignableFrom(HttpSession.class)) {
                parameterObject.add(request.getSession());
            } else if (parameter.getType().isAssignableFrom(ServletContext.class)) {
                parameterObject.add(this.getServletContext());
            } else if (parameter.getType().isAssignableFrom(Part.class)) {
                parameterObject.add(request.getPart(paramName));
            } else if (parameter.getType().isAssignableFrom(Part[].class)) {
                parameterObject.add(request.getParts());
            } else if (parameter.getType().isAssignableFrom(byte.class)
                    || parameter.getType().isAssignableFrom(Byte.class)) {
                value = (value == null ? request.getParameter(paramName) : value);
                parameterObject.add(Byte.valueOf(value));
            } else if (parameter.getType().isAssignableFrom(short.class)
                    || parameter.getType().isAssignableFrom(Short.class)) {
                value = (value == null ? request.getParameter(paramName) : value);
                parameterObject.add(Short.valueOf(value));
            } else if (parameter.getType().isAssignableFrom(int.class)
                    || parameter.getType().isAssignableFrom(Integer.class)) {
                value = (value == null ? request.getParameter(paramName) : value);
                parameterObject.add(Integer.valueOf(value));
            } else if (parameter.getType().isAssignableFrom(long.class)
                    || parameter.getType().isAssignableFrom(Long.class)) {
                value = (value == null ? request.getParameter(paramName) : value);
                parameterObject.add(Long.valueOf(value));
            } else if (parameter.getType().isAssignableFrom(float.class)
                    || parameter.getType().isAssignableFrom(Float.class)) {
                value = (value == null ? request.getParameter(paramName) : value);
                parameterObject.add(Float.valueOf(value));
            } else if (parameter.getType().isAssignableFrom(double.class)
                    || parameter.getType().isAssignableFrom(Double.class)) {
                value = (value == null ? request.getParameter(paramName) : value);
                parameterObject.add(Double.valueOf(value));
            } else if (parameter.getType().isAssignableFrom(String.class)) {
                value = (value == null ? request.getParameter(paramName) : value);
                parameterObject.add(value);
            } else if (parameter.getType().isAssignableFrom(String[].class)) {
                String[] values;
                if (headerAnotation != null) {
                    Enumeration<String> headers = request.getHeaders(paramName);
                    List<String> headerValues = new ArrayList<>();
                    while (headers.hasMoreElements()) {
                        headerValues.add(headers.nextElement());
                    }
                    values = headerValues.toArray(new String[0]);
                } else {
                    values = request.getParameterValues(paramName);
                }
                parameterObject.add(values);
            } else if (parameter.getType().isAssignableFrom(Map.class)) {
                parameterObject.add(request.getParameterMap());
            } else if (parameter.getType().isAssignableFrom(Date.class)) {
                value = (value == null ? request.getParameter(paramName) : value);
                try {
                    Date date = dateFormat.parse(value);
                    parameterObject.add(date);
                } catch (Exception e) {
                    parameterObject.add(null);
                }
            } else if (!parameter.getType().isInterface()) {
                String contentType = request.getContentType();
                if (contentType != null && contentType.contains("application/json")) {
                    parameterObject.add(populateJSONData(request, parameter.getType()));
                } else {
                    parameterObject.add(populateFormData(request, parameter.getType()));
                }
            } else {
                parameterObject.add(null);
            }
        }
        return parameterObject.toArray();
    }

    private <T> T populateJSONData(HttpServletRequest request, Class<T> type) {
        ObjectMapper mapper = new ObjectMapper();
        T obj = null;
        try {
            obj = mapper.readValue(request.getInputStream(), type);
        } catch (IOException e) {
            // TODO Auto-generated catch block
        }
        return obj;
    }

    private <T> T populateFormData(HttpServletRequest request, Class<T> clazz) {
        T bean;
        try {
            bean = clazz.getConstructor().newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String value = request.getParameter(field.getName());
                if (value != null) {
                    if (field.getType().isAssignableFrom(boolean.class)) {
                        field.setBoolean(bean, true);
                    } else if (field.getType().isAssignableFrom(Boolean.class)) {
                        field.set(bean, Boolean.TRUE);
                    }
                    if (field.getType().isAssignableFrom(int.class)) {
                        field.setInt(bean, Integer.parseInt(value));
                    } else if (field.getType().isAssignableFrom(Integer.class)) {
                        field.set(bean, Integer.valueOf(value));
                    } else if (field.getType().isAssignableFrom(byte.class)) {
                        field.setByte(bean, Byte.parseByte(value));
                    } else if (field.getType().isAssignableFrom(Byte.class)) {
                        field.set(bean, Integer.valueOf(value));
                    } else if (field.getType().isAssignableFrom(short.class)) {
                        field.setShort(bean, Short.parseShort(value));
                    } else if (field.getType().isAssignableFrom(Short.class)) {
                        field.set(bean, Short.valueOf(value));
                    } else if (field.getType().isAssignableFrom(long.class)) {
                        field.setLong(bean, Long.parseLong(value));
                    } else if (field.getType().isAssignableFrom(Long.class)) {
                        field.set(bean, Long.valueOf(value));
                    } else if (field.getType().isAssignableFrom(float.class)) {
                        field.setFloat(bean, Float.parseFloat(value));
                    } else if (field.getType().isAssignableFrom(Float.class)) {
                        field.set(bean, Float.valueOf(value));
                    } else if (field.getType().isAssignableFrom(double.class)) {
                        field.setDouble(bean, Double.parseDouble(value));
                    } else if (field.getType().isAssignableFrom(Double.class)) {
                        field.set(bean, Double.valueOf(value));
                    } else if (field.getType().isAssignableFrom(String[].class)) {
                        String[] values = request.getParameterValues(field.getName());
                        field.set(bean, values);
                    } else if (field.getType().isAssignableFrom(String.class)) {
                        field.set(bean, value);
                    } else if (field.getType().isAssignableFrom(Date.class)) {
                        try {
                            Date date = dateFormat.parse(value);
                            field.set(bean, date);
                        } catch (Exception e) {
                            field.set(bean, null);
                        }
                    }
                } else {
                    if (field.getType().isAssignableFrom(boolean.class)) {
                        field.setBoolean(bean, false);
                    } else if (field.getType().isAssignableFrom(Boolean.class)) {
                        field.set(bean, Boolean.FALSE);
                    }
                }
            }
        } catch (InstantiationException |
                 IllegalAccessException |
                 NoSuchMethodException |
                 SecurityException |
                 InvocationTargetException e) {
            e.printStackTrace();
            bean = null;
        }
        return bean;
    }
}
