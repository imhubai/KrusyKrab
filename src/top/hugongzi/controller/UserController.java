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
import java.util.List;
import java.util.Objects;

@Controller
public class UserController {
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
    public ModelAndView addOrder(@RequestParam(name = "cart") String cart, HttpSession session) {
        ObjectMapper objectMapper = new ObjectMapper();
        ModelAndView mv = new ModelAndView("page/orderresult");
        try {
            Cart cartResponse = objectMapper.readValue(cart, Cart.class);
            ShopService shopService = new ShopServiceImpl();
            Shop shop = shopService.getShopByShopId((String) session.getAttribute(Vars.orderShopId));
            mv.addObject("action", cartResponse.getAction());
            mv.addObject("cartJson", cart);
            mv.addObject("shopName", shop.getShopName());
            mv.addObject("shopAddress", shop.getShopAddress());
            mv.addObject("shopPhone", shop.getShopPhone());
            mv.addObject("price", cartResponse.getPrice());
            mv.addObject("cartList", cartResponse.getItems().values().toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    @RequestMapping("/order/orderResult")
    public String orderResult(@RequestParam(name = "cart") String cart, @RequestParam(name = "payReturn") String isPaid, HttpSession session) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        UserService userService = new UserServiceImpl();
        Cart cartResponse = objectMapper.readValue(cart, Cart.class);
        long result = userService.addOrder(cartResponse, (String) session.getAttribute(Vars.orderShopId), (String) session.getAttribute(Vars.currentUser), isPaid, cart);
        return "return:" + result;
    }

    @RequestMapping("/order/orderDetail")
    public ModelAndView orderDetail(@RequestParam(name = "orderId") String orderId, HttpSession session) throws Exception {
        if (orderId == null || orderId.isEmpty()) {
            return new ModelAndView("page/orderhistory");
        }
        ModelAndView mv = new ModelAndView("page/orderdetail");
        ObjectMapper objectMapper = new ObjectMapper();
        ShopService shopService = new ShopServiceImpl();
        Shop shop = shopService.getShopByShopId((String) session.getAttribute(Vars.orderShopId));
        UserService userService = new UserServiceImpl();
        UserOrder userOrder = userService.getOrder(Integer.parseInt(orderId));
        Cart cartResponse = objectMapper.readValue(userOrder.getCartJson(), Cart.class);
        mv.addObject("shopName", shop.getShopName());
        mv.addObject("shopAddress", shop.getShopAddress());
        mv.addObject("shopPhone", shop.getShopPhone());
        mv.addObject("obj", userOrder);
        mv.addObject("cart", userOrder.getCartJson());
        mv.addObject("cartList", cartResponse.getItems().values().toArray());
        return mv;
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
    public ModelAndView history(HttpSession session) throws Exception {
        UserService userService = new UserServiceImpl();
        List<UserOrder> orderList = userService.getUserOrderByUserId((String) session.getAttribute(Vars.currentUser));
        if (orderList == null || orderList.isEmpty()) {
            return new ModelAndView("page/orderhistory_null");
        }
        ModelAndView mv = new ModelAndView("page/orderhistory");
        mv.addObject("orderList", orderList);
        return mv;
    }

    @RequestMapping("/order/my")
    public ModelAndView my(HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView("page/ordermy");
        UserService userService = new UserServiceImpl();
        User user = userService.getUserByUserId((String) session.getAttribute(Vars.currentUser));
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

        UserService userService = new UserServiceImpl();
        try {
            if (userService.validate(username, userpassword)) {
                session.setAttribute(Vars.currentUser, userService.getUserByUserId(username).getUserId());
                return "redirect:order";
            } else {
                return "redirect:./error?msg=error_pwd";
            }
        } catch (Exception e) {
            return "page/login";
        }
    }

    @RequestMapping("/register")
    public ModelAndView userRegister() {
        return new ModelAndView("page/register");
    }

    @RequestMapping("/order/logout")
    public String logout(HttpSession session) {
        Vars.currentUser = "";
        session.setAttribute(Vars.currentUser, null);
        return "return:200";
    }

    @RequestMapping("/registerUser")
    public String registerUser(@RequestParam(name = "userId") String userId, @RequestParam(name = "password") String password, @RequestParam(name = "nickname") String nickname, @RequestParam(name = "phone") String phone, @RequestParam(name = "sex") String sex, @RequestParam(name = "birthday") String birthday, @RequestParam(name = "email") String email, HttpSession session) {
        UserService userService = new UserServiceImpl();
        if (userService.registerUser(userId, password, nickname, phone, sex, birthday, email)) {
            session.setAttribute(Vars.currentUser, userId);
            return "redirect:order";
        } else {
            return "redirect:./error?msg=error_registerUser";
        }

    }
}
