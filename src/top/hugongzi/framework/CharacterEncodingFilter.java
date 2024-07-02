package top.hugongzi.framework;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 字符集编码过滤器，用于统一设置请求和响应的字符集编码。
 */
public class CharacterEncodingFilter implements Filter {

    private String encoding;

    /**
     * 初始化过滤器，从配置中获取字符集编码。
     * 如果未配置，则默认使用UTF-8字符集。
     *
     * @param filterConfig 过滤器配置对象
     * @throws ServletException 如果初始化过程中出现异常
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
        if (this.encoding == null) {
            this.encoding = "UTF-8";
        }
    }

    /**
     * 处理请求和响应，设置请求和响应的字符集编码。
     *
     * @param request  请求对象
     * @param response 响应对象
     * @param chain    过滤器链，用于继续处理请求
     * @throws IOException      如果处理过程中出现IO异常
     * @throws ServletException 如果处理过程中出现Servlet异常
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        req.setCharacterEncoding(this.encoding);
        resp.setCharacterEncoding(this.encoding);
        resp.setContentType("text/html;charset=" + this.encoding);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
