package top.hugongzi.controller;

import top.hugongzi.constant.Vars;
import top.hugongzi.entity.Shop;
import top.hugongzi.framework.annotations.Controller;
import top.hugongzi.framework.annotations.RequestMapping;
import top.hugongzi.framework.annotations.RequestParam;
import top.hugongzi.framework.model.ModelAndView;
import top.hugongzi.service.ShopService;
import top.hugongzi.service.ShopServiceImpl;
import top.hugongzi.service.UserService;
import top.hugongzi.service.UserServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller
public class UserContorller {

    UserService userService;

    @RequestMapping("/order")
    public String order(HttpSession session) {
        if (session.getAttribute(Vars.currentUser) == null || session.getAttribute(Vars.currentUser) == "") {
            return "redirect:login";
        }
        if (session.getAttribute(Vars.orderShopId) == null || session.getAttribute(Vars.orderShopId) == "") {
            return "redirect:order/chooseShop";
        }
        return "page/order";
    }

    @RequestMapping("/order/address")
    public String orderAddress(HttpSession session, @RequestParam(name = "shopId") String shopId) throws Exception {
        if (shopId != null) {
            ShopService shopService = new ShopServiceImpl();
            if (shopService.getShopByShopId(shopId) == null) {
                return "redirect:order";
            }
            session.setAttribute(Vars.orderShopId, shopId);
            return "page/order";
        }
        return "redirect:order";
    }

    @RequestMapping("/order/chooseShop")
    public ModelAndView chooseShop() throws Exception {
        ShopService shopService = new ShopServiceImpl();
        List<Shop> shop = shopService.getAllShop(0, 10000);
        ModelAndView mv = new ModelAndView("page/orderaddress");
        mv.addObject("shoplist",shop);
        return mv;
    }

    @RequestMapping("/login")
    public String login(@RequestParam(name = "username") String username, @RequestParam(name = "userpassword") String userpassword, HttpSession session) {
        if (session.getAttribute(Vars.currentUser) != null) {
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
                return "return:Wrong Account or Password.";
            }
        } catch (Exception e) {
            return "page/login";
        }
    }
}
