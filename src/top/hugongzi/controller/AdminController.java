package top.hugongzi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import top.hugongzi.dao.AdminDaoImpl;
import top.hugongzi.dao.ProductDaoImpl;
import top.hugongzi.dao.ShopDaoImpl;
import top.hugongzi.dao.UserDaoImpl;
import top.hugongzi.entity.Admin;
import top.hugongzi.entity.Product;
import top.hugongzi.entity.Shop;
import top.hugongzi.entity.User;
import top.hugongzi.framework.annotations.Controller;
import top.hugongzi.framework.annotations.RequestMapping;
import top.hugongzi.framework.annotations.RequestParam;
import top.hugongzi.framework.db.JDBCTemplate;
import top.hugongzi.framework.db.PageInfo;
import top.hugongzi.framework.model.ModelAndView;
import top.hugongzi.service.*;

import java.util.List;
import java.util.Objects;

@Controller
public class AdminController {
    private AdminService adminService;
    private ShopService shopService;
    private UserService userService;
    private ProductService productService;

    public AdminController() {
        adminService = new AdminServiceImpl();
        shopService = new ShopServiceImpl();
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


    /*Admin管理层 Admin管理层Admin管理层Admin管理层
    Admin管理层 Admin管理层Admin管理层Admin管理层
    Admin管理层Admin管理层Admin管理层 Admin管理层
    Admin管理层Admin管理层Admin管理层 Admin管理层
    Admin管理层Admin管理层Admin管理层 Admin管理层
    Admin管理层Admin管理层Admin管理层 Admin管理层*/


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

    /*shop管理层shop管理层shop管理层 shop管理层
    shop管理层 shop管理层shop管理层shop管理层
    shop管理层 shop管理层shop管理层 shop管理层
    shop管理层shop管理层 shop管理层shop管理层
    shop管理层shop管理层shop管理层 shop管理层
    shop管理层shop管理层shop管理层 shop管理层
    shop管理层shop管理层shop管理层 shop管理层
    shop管理层shop管理层shop管理层 shop管理层
    shop管理层 shop管理层shop管理层shop管理层*/

    /**
     * 删除店铺
     *
     * @param sid 商铺ID，用于指定要删除的商铺
     * @return 返回字符串表示操作结果。
     * @throws Exception 删除操作异常。
     */
    @RequestMapping("/admin/deleteShop")
    public String delectShop(@RequestParam(name = "sid") String sid) throws Exception {
        shopService = new ShopServiceImpl();
        if (adminService.deleteAdmin(Integer.parseInt(sid))) {
            return "return:200";
        } else return "return:400";
    }

    /**
     * 根据商铺ID获取商铺信息。
     * 该方法处理来自商铺界面的请求，用于获取特定商铺的详细信息。
     *
     * @param sid - 商铺ID，用于识别要获取信息的商铺。
     * @return 以字符串形式返回的JSON对象，包含商铺的信息。
     */
    @RequestMapping("/admin/getShop")
    public String getShop(@RequestParam(name = "sid") String sid) throws Exception {
        shopService = new ShopServiceImpl();
        int sid_int = Objects.equals(sid, null) ? -1 : Integer.parseInt(sid);
        Shop shop = shopService.getShopById(sid_int);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(shop);
        return "return:" + json;
    }

    @RequestMapping("/admin/editShop")
    public String editShop(@RequestParam(name = "sid") String sid, @RequestParam(name = "shopid") String shopId, @RequestParam(name = "shopname") String shopName, @RequestParam(name = "shopaddress") String shopAddress, @RequestParam(name = "shoptype") String shopType, @RequestParam(name = "shopphone") String shopPhone) throws Exception {
        shopService = new ShopServiceImpl();
        if (shopService.editShop(Integer.parseInt(sid), shopId, shopName, shopAddress, shopPhone, shopType)) {
            return "return:200";
        } else {
            return "return:400";
        }
    }


    /**
     * 删除用户
     *
     * @param uid 用户ID，用于指定要删除的用户
     * @return 返回字符串表示操作结果。
     * @throws Exception 删除操作异常。
     */
    @RequestMapping("/admin/deleteUser")
    public String delectUser(@RequestParam(name = "uid") String uid) throws Exception {
        userService = new UserServiceImpl();
        if (userService.deleteUser(Long.parseLong(uid))) {
            return "return:200";
        } else return "return:400";
    }

    /**
     * 根据用户ID获取商铺信息。
     * 该方法处理来自用户界面的请求，用于获取特定用户的详细信息。
     *
     * @param uid - 用户ID，用于识别要获取信息的用户。
     * @return 以字符串形式返回的JSON对象，包含用户的信息。
     */
    @RequestMapping("/admin/getUser")
    public String getUser(@RequestParam(name = "uid") String uid) throws Exception {
        userService = new UserServiceImpl();
        Long uid_long = Objects.equals(uid, null) ? -1 : Long.parseLong(uid);
        User user = userService.getUserById(uid_long);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return "return:" + json;
    }

    @RequestMapping("/admin/editUser")
    public String editUser(@RequestParam(name = "uid") long uid, @RequestParam(name = "userid") String userid, @RequestParam(name = "password") String password, @RequestParam(name = "nickname") String nickname, @RequestParam(name = "email") String email, @RequestParam(name = "sex") String sex, @RequestParam(name = "phone") String phone, @RequestParam(name = "birthday") String birthday, @RequestParam(name = "usertype") String usertype, @RequestParam(name = "avatar") String avatar) {
        userService = new UserServiceImpl();
        if (userService.editUser(uid, userid, password, nickname, email, sex, phone, birthday, usertype, avatar)) {
            return "return:200";
        } else {
            return "return:400";
        }
    }
    /*product管理层 product管理层product管理层product管理层
    product管理层 product管理层product管理层product管理层
    product管理层product管理层product管理层 product管理层
    product管理层product管理层product管理层 product管理层
    product管理层product管理层product管理层 product管理层
    product管理层product管理层product管理层 product管理层
    product管理层 product管理层product管理层product管理层
    product管理层product管理层product管理层 product管理层
    product管理层product管理层product管理层 product管理层
    product管理层product管理层product管理层 product管理层
    product管理层 product管理层product管理层 product管理层
    product管理层 product管理层product管理层 product管理层
    product管理层 product管理层product管理层 product管理层*/

    /**
     * 删除产品
     *
     * @param pid 产品ID，用于指定要删除的产品
     * @return 返回字符串表示操作结果。
     * @throws Exception 删除操作异常。
     */
    @RequestMapping("/admin/deleteProduct")
    public String deleteProduct(@RequestParam(name = "pid") String pid) throws Exception {
        productService = new ProductServiceImpl();
        if (productService.deleteProduct(Long.parseLong(pid))) {
            return "return:200";
        } else return "return:400";
    }

    /**
     * 根据产品ID获取产品信息。
     * 该方法处理来自产品界面的请求，用于获取特定商铺的详细信息。
     *
     * @param pid - 产品ID，用于识别要获取信息的产品。
     * @return 以字符串形式返回的JSON对象，包含商铺的信息。
     */
    @RequestMapping("/admin/getProduct")
    public String getProduct(@RequestParam(name = "pid") String pid) throws Exception {
        productService = new ProductServiceImpl();
        Long pid_long = Objects.equals(pid, null) ? -1 : Long.parseLong(pid);
        Product product = productService.getProductById(pid_long);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(product);
        return "return:" + json;
    }

    @RequestMapping("/admin/editProduct")
    public String editProduct(@RequestParam(name = "pid") String pid, @RequestParam(name = "productId") String productId, @RequestParam(name = "productName") String productName, @RequestParam(name = "productImg") String productImg, @RequestParam(name = "productPrice") Double productPrice, @RequestParam(name = "productType") String productType, @RequestParam(name = "productDescription") String productDescription, @RequestParam(name = "productTags") String productTags) throws Exception {
        productService = new ProductServiceImpl();
        if (productService.editProduct(Long.parseLong(pid), productId, productName, productImg, productPrice, productType, productDescription, productTags)) {
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
                return func_p3(curPageStr);
            case "p4":
                return func_p4(curPageStr);
            case "p5":
                return func_p5(curPageStr);
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

    private ModelAndView func_p3(String curPageStr) {
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("admin/admin-page-p3");
        try {
            int curPage = Objects.equals(curPageStr, "") ? 1 : Integer.parseInt(curPageStr);
            PageInfo<Shop> pageInfo = JDBCTemplate.getPage("select * from shop", new ShopDaoImpl().getRowMapper(), curPage);
            List<Shop> list = pageInfo.getList();
            modelAndView.addObject("list", list);
            modelAndView.addObject("total", pageInfo.getTotalPage());
            modelAndView.addObject("recnum", pageInfo.getRecNum());
            shopService = new ShopServiceImpl();
            modelAndView.addObject("count", shopService.getShopCount());
            modelAndView.addObject("curpage", curPage);
        } catch (Exception ignored) {
        }
        return modelAndView;
    }

    private ModelAndView func_p4(String curPageStr) {
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("admin/admin-page-p4");
        try {
            int curPage = Objects.equals(curPageStr, "") ? 1 : Integer.parseInt(curPageStr);
            PageInfo<User> pageInfo = JDBCTemplate.getPage("select * from user", new UserDaoImpl().getRowMapper(), curPage);
            List<User> list = pageInfo.getList();
            modelAndView.addObject("list", list);
            modelAndView.addObject("total", pageInfo.getTotalPage());
            modelAndView.addObject("recnum", pageInfo.getRecNum());
            userService = new UserServiceImpl();
            modelAndView.addObject("count", userService.getUserCount());
            modelAndView.addObject("curpage", curPage);
        } catch (Exception ignored) {
        }
        return modelAndView;
    }

    private ModelAndView func_p5(String curPageStr) {
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("admin/admin-page-p5");
        try {
            int curPage = Objects.equals(curPageStr, "") ? 1 : Integer.parseInt(curPageStr);
            PageInfo<Product> pageInfo = JDBCTemplate.getPage("select * from product", new ProductDaoImpl().getRowMapper(), curPage);
            List<Product> list = pageInfo.getList();
            modelAndView.addObject("list", list);
            modelAndView.addObject("total", pageInfo.getTotalPage());
            modelAndView.addObject("recnum", pageInfo.getRecNum());
            productService = new ProductServiceImpl();
            modelAndView.addObject("count", productService.getProductCount());
            modelAndView.addObject("curpage", curPage);
        } catch (Exception ignored) {
        }
        return modelAndView;
    }
}
