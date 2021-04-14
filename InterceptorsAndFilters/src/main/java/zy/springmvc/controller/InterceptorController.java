package zy.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zy.springmvc.exception.SysException;

@Controller
@RequestMapping("/interceptor")
public class InterceptorController {
    @RequestMapping("/testInterceptor")
    public String testInterceptor() throws SysException {
        System.out.println("testInterceptor方法正在执行....");
        return "success";
    }
}
