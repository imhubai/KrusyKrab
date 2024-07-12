package top.hugongzi.controller;

import top.hugongzi.framework.annotations.Controller;
import top.hugongzi.framework.annotations.RequestMapping;
import top.hugongzi.framework.model.ModelAndView;

/**
 * 控制器类，用于处理前端的首页请求。
 */
@Controller
public class PageController {
    /**
     * 处理首页的请求。
     *
     * @return ModelAndView 对象，指定渲染的页面。
     */
    @RequestMapping("/index")
    public ModelAndView kkIndex() {
        return new ModelAndView("page/index");
    }
}
