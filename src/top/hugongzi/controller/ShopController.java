package top.hugongzi.controller;

import top.hugongzi.constant.Vars;
import top.hugongzi.entity.UserOrder;
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

@Controller
public class ShopController {
    @RequestMapping("/shop")
    public ModelAndView shop(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("page/shop");
        session.setAttribute(Vars.currentShop, 1);
        int sid = (int) session.getAttribute(Vars.currentShop);
        try {
            int curPage = 1;
            ShopService shopService = new ShopServiceImpl();
            List<UserOrder> list = shopService.getUserOrderBySid(sid);
            modelAndView.addObject("list", list);
            modelAndView.addObject("total", 1);
            modelAndView.addObject("recnum", list.size());
            modelAndView.addObject("count", shopService.getOrderCount(sid));
            modelAndView.addObject("curpage", curPage);
        } catch (Exception ignored) {
        }
        return modelAndView;
    }

    @RequestMapping("/shop/getDetail")
    public String getOrderDetail(@RequestParam(name = "orderId") String orderId) throws Exception {
        UserService userService = new UserServiceImpl();
        return "return:" + userService.getOrder(Integer.parseInt(orderId)).getCartJson();
    }

    @RequestMapping("/shop/getUserorder")
    public String getUserorder(@RequestParam(name = "oid") String oid, HttpSession session) throws Exception {
        UserService userService= new UserServiceImpl();
        return "return:" + userService.getOrder(Integer.parseInt(oid)).getOrderState();
    }

    @RequestMapping("/shop/changeState")
    public String changeState(@RequestParam(name = "oid") String oid,@RequestParam(name="state") String state, HttpSession session) throws Exception {
        UserService userService= new UserServiceImpl();
        if(userService.changeState(Integer.parseInt(oid),state)) return "return:200";
        else return "return:401";
    }
}
