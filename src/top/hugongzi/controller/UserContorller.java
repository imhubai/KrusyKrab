package top.hugongzi.controller;

import top.hugongzi.framework.annotations.Controller;
import top.hugongzi.framework.annotations.RequestMapping;
import top.hugongzi.framework.annotations.RequestParam;
import top.hugongzi.framework.model.ModelAndView;
import top.hugongzi.service.UserService;
import top.hugongzi.service.UserServiceImpl;

import java.util.Objects;

@Controller
public class UserContorller {

    UserService userService;

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam(name = "username") String username, @RequestParam(name = "userpassword") String userpassword) {
        if (Objects.equals(username, "") || Objects.equals(userpassword, "")) {
            return new ModelAndView("page/login");
        }

        userService = new UserServiceImpl();
        ModelAndView modelAndView;
        try {
            if (userService.validate(username, userpassword)) {
                modelAndView = new ModelAndView("page/order");
            } else {
                modelAndView = new ModelAndView("page/login");
                modelAndView.addObject("errorMessage", "账号或密码错误");
            }
        } catch (Exception e) {
            modelAndView = new ModelAndView("page/login");
            modelAndView.addObject("errorMessage", "服务器状态错误");
        }
        return modelAndView;
    }
}
