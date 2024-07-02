package top.hugongzi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import top.hugongzi.dao.AdminDaoImpl;
import top.hugongzi.entity.Admin;
import top.hugongzi.framework.annotations.Controller;
import top.hugongzi.framework.annotations.RequestMapping;
import top.hugongzi.framework.annotations.RequestParam;
import top.hugongzi.framework.db.JDBCTemplate;
import top.hugongzi.framework.db.PageInfo;
import top.hugongzi.framework.model.ModelAndView;
import top.hugongzi.service.AdminService;
import top.hugongzi.service.AdminServiceImpl;

import java.util.List;
import java.util.Objects;

@Controller
public class AdminController {
    private AdminService adminService;

    public AdminController() {
        adminService = new AdminServiceImpl();
    }

    /**
     * 处理管理员登录请求。
     * 登录验证失败或发生异常时，重定向到登录页面，并显示相应错误信息。
     * 验证成功后，重定向到管理员主页面。
     *
     * @param adminId       管理员账号。
     * @param adminPassword 管理员账号密码。
     * @return 登录成功返回管理员主页面，失败返回登录页面。
     */
    @RequestMapping("/admin")
    public ModelAndView login(@RequestParam(name = "adminid") String adminId, @RequestParam(name = "adminpassword") String adminPassword) {
        if (Objects.equals(adminId, "") || Objects.equals(adminPassword, "")) {
            return new ModelAndView("page/adminlogin");
        }
        adminService = new AdminServiceImpl();
        ModelAndView modelAndView;
        try {
            if (adminService.validate(adminId, adminPassword)) {
                modelAndView = new ModelAndView("page/admin");
                modelAndView.addObject("page", "p1");
            } else {
                modelAndView = new ModelAndView("page/adminlogin");
                modelAndView.addObject("errorMessage", "账号或密码错误");
            }
        } catch (Exception e) {
            modelAndView = new ModelAndView("page/adminlogin");
            modelAndView.addObject("errorMessage", "服务器状态错误");
        }
        return modelAndView;
    }

    /**
     * 删除管理员
     *
     * @param aid 管理员ID，用于指定要删除的管理员
     * @return 返回字符串表示操作结果。
     * @throws Exception 删除操作异常。
     */
    @RequestMapping("/admin/deleteAdmin")
    public String deleteAdmin(@RequestParam(name = "aid") String aid) throws Exception {
        adminService = new AdminServiceImpl();
        if (adminService.deleteAdmin(Integer.parseInt(aid))) {
            return "return:200";
        } else return "return:400";
    }

    /**
     * 根据管理员ID获取管理员信息。
     * 该方法处理来自管理员界面的请求，用于获取特定管理员的详细信息。
     *
     * @param aid - 管理员ID，用于识别要获取信息的管理员。
     * @return 以字符串形式返回的JSON对象，包含管理员的信息。
     */
    @RequestMapping("/admin/getAdmin")
    public String getAdmin(@RequestParam(name = "aid") String aid) throws Exception {
        adminService = new AdminServiceImpl();
        int aid_int = Objects.equals(aid, null) ? -1 : Integer.parseInt(aid);
        Admin admin = adminService.getAdminById(aid_int);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(admin);
        return "return:" + json;
    }

    @RequestMapping("/admin/editAdmin")
    public String editAdmin(@RequestParam(name = "aid") String aid, @RequestParam(name = "adminid") String adminId, @RequestParam(name = "adminname") String adminName, @RequestParam(name = "adminpassword") String adminPassword, @RequestParam(name = "admintype") String adminType) throws Exception {
        adminService = new AdminServiceImpl();
        if (adminService.editAdmin(Integer.parseInt(aid), adminId, adminName, adminPassword, adminType)) {
            return "return:200";
        } else {
            return "return:400";
        }
    }

    @RequestMapping("/admin/page")
    public ModelAndView changePage(@RequestParam(name = "p") String page, @RequestParam(name = "curPage") String curPageStr) throws Exception {
        ModelAndView modelAndView;
        switch (page) {
            case "p1":
                modelAndView = new ModelAndView("admin/admin-page-p1");
                try {
                    //todo
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return modelAndView;
            case "p2":
                return func_p2(curPageStr);
            case "p3":
                modelAndView = new ModelAndView("admin/admin-page-p3");
                break;
            case "p4":
                modelAndView = new ModelAndView("admin/admin-page-p4");
                break;
            case "p5":
                modelAndView = new ModelAndView("admin/admin-page-p5");
                break;
            case "p6":
                modelAndView = new ModelAndView("admin/admin-page-p6");
                break;
            default:
                modelAndView = null;
                break;
        }
        if (modelAndView != null) {
            modelAndView.addObject("page", page);
        }
        return modelAndView;
    }

    private ModelAndView func_p2(String curPageStr) {
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("admin/admin-page-p2");
        try {
            int curPage = Objects.equals(curPageStr, "") ? 1 : Integer.parseInt(curPageStr);
            PageInfo<Admin> pageInfo = JDBCTemplate.getPage("select * from admin", new AdminDaoImpl().getRowMapper(), curPage);
            List<Admin> list = pageInfo.getList();
            modelAndView.addObject("list", list);
            modelAndView.addObject("total", pageInfo.getTotalPage());
            modelAndView.addObject("recnum", pageInfo.getRecNum());
            adminService = new AdminServiceImpl();
            modelAndView.addObject("count", adminService.getAdminCount());
            modelAndView.addObject("curpage", curPage);
        } catch (Exception ignored) {
        }
        return modelAndView;
    }
}
