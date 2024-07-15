package top.hugongzi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import top.hugongzi.constant.Vars;
import top.hugongzi.entity.*;
import top.hugongzi.framework.annotations.Controller;
import top.hugongzi.framework.annotations.RequestMapping;
import top.hugongzi.framework.annotations.RequestParam;
import top.hugongzi.framework.model.ModelAndView;
import top.hugongzi.service.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Controller
public class UserController {
    UserService userService;

    @RequestMapping("/order")
    public String order(HttpSession session) {
        if (session.getAttribute(Vars.currentUser) == null || session.getAttribute(Vars.currentUser) == "") {
            return "redirect:login";
        }
        if (session.getAttribute(Vars.orderShopId) == null || session.getAttribute(Vars.orderShopId) == "") {
            return "redirect:order/chooseShop";
        }
        return "redirect:order/dishes";
    }

    @RequestMapping("/order/dishes")
    public ModelAndView dishes(HttpSession session) throws Exception {
        ShopService shopService = new ShopServiceImpl();
        ProductService productService = new ProductServiceImpl();
        ModelAndView mv = new ModelAndView("page/order");
        Shop shop = shopService.getShopByShopId((String) session.getAttribute(Vars.orderShopId));
        if (shop == null) mv = new ModelAndView("page/orderaddress");
        else {
            List<ProductType> productTypes = productService.getProductTypes();
            for (ProductType productType : productTypes) {
                productType.setProducts(productService.getProductsByType(productType.getTypeId()));
            }
            mv.addObject("shop", shop);
            mv.addObject("productTypes", productTypes);
        }
        return mv;
    }

    @RequestMapping("/order/address")
    public String orderAddress(HttpSession session, @RequestParam(name = "shopId") String shopId) throws Exception {
        if (shopId != null) {
            ShopService shopService = new ShopServiceImpl();
            if (shopService.getShopByShopId(shopId) == null) return "redirect:./error?msg=error_address";
            session.setAttribute(Vars.orderShopId, shopId);
        }
        return "redirect:../order";
    }

    @RequestMapping("/order/addOrder")
    public ModelAndView addOrder(@RequestParam(name = "cart") String cart) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Cart cartResponse = objectMapper.readValue(cart, Cart.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("page/orderdetail");
    }

    @RequestMapping("/order/switchShop")
    public String switchShop(HttpSession session) {
        session.setAttribute(Vars.orderShopId, null);
        return "return:200";
    }

    @RequestMapping("/order/getProduct")
    public String getProduct(@RequestParam(name = "productId") String productId) throws Exception {
        ProductService productService = new ProductServiceImpl();
        Product product = productService.getProductByProductId(productId);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(product);
        return "return:" + json;
    }

    @RequestMapping("/order/getProductTypeName")
    public String getProductType(@RequestParam(name = "productId") String productId) throws Exception {
        ProductService productService = new ProductServiceImpl();
        ProductType productType = productService.getProductTypeByProductId(productId);
        return "return:" + productType.getTypeName();
    }

    @RequestMapping("/order/chooseShop")
    public ModelAndView chooseShop() throws Exception {
        ShopService shopService = new ShopServiceImpl();
        List<Shop> shop = shopService.getAllShop(0, 10000);
        ModelAndView mv = new ModelAndView("page/orderaddress");
        mv.addObject("shoplist", shop);
        return mv;
    }

    @RequestMapping("/order/history")
    public ModelAndView history() {
        UserService userService = new UserServiceImpl();
       // userService.getUserOrder();
        ModelAndView mv = new ModelAndView("page/orderhistory");
        return mv;
    }

    @RequestMapping("/order/my")
    public ModelAndView my() throws Exception {
        ModelAndView mv = new ModelAndView("page/ordermy");
        UserService userService = new UserServiceImpl();
        User user = userService.getUserByName(Vars.currentUser);
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping("/login")
    public String login(@RequestParam(name = "username") String username, @RequestParam(name = "userpassword") String userpassword, HttpSession session) {
        if (session.getAttribute(Vars.currentUser) != null && session.getAttribute(Vars.currentUser) != "") {
            return "redirect:order";
        }
        if (Objects.equals(username, "") || Objects.equals(userpassword, "")) {
            return "page/login";
        }

        userService = new UserServiceImpl();
        try {
            if (userService.validate(username, userpassword)) {
                Vars.currentUser = username;
                session.setAttribute(Vars.currentUser, userService.getUserByName(username));
                return "redirect:order";
            } else {
                return "redirect:./error?msg=error_pwd";
            }
        } catch (Exception e) {
            return "page/login";
        }
    }
    @RequestMapping("/order/logout")
    public String logout(HttpSession session){
        Vars.currentUser = "";
        session.setAttribute(Vars.currentUser, null);
        return "return:200";
    }
}
