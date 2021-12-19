package zy.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody//将所有的返回请求返回浏览器, 写在方法上只对方法有效
//@Controller
@RestController//以上两个可以合并为一个RestController
@Slf4j
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        log.info("Hello World!");
        return "Hello World!";
    }
}
