package top.hugongzi.controller;

import top.hugongzi.framework.annotations.Controller;
import top.hugongzi.framework.annotations.RequestMapping;
import top.hugongzi.framework.model.ModelAndView;

@Controller
public class PageController {
    @RequestMapping("/index")
    public ModelAndView mallIndex() {
        return new ModelAndView("page/index");
    }
    @RequestMapping("/order")
    public ModelAndView mallLogin() {
        return new ModelAndView("page/admin");
    }
}
