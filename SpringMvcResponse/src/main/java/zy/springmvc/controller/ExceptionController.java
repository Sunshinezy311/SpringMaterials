package zy.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zy.springmvc.exception.SysException;

@Controller
@RequestMapping("/exception")
public class ExceptionController {
    @RequestMapping("/testException")
    public String testException() throws SysException {
        System.out.println("testException方法正在执行....");
        try {
            int a = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("错误！除数不能为0");
        }
        return "success";
    }
}
