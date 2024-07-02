package top.hugongzi.controller;

import top.hugongzi.framework.annotations.Controller;
import top.hugongzi.framework.annotations.RequestMapping;
import top.hugongzi.framework.annotations.RequestParam;
import top.hugongzi.framework.annotations.ResponseBody;

@Controller
public class TestContorller {
    @RequestMapping("/test")
    @ResponseBody
    public String test(@RequestParam(name = "para") String para) {
        return para;
    }
}
