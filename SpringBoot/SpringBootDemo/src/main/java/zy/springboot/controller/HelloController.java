package zy.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

//@ResponseBody\@Controller两个可以合并为一个RestController
//但注意如果用了ResponseBody,就不能返回页面了
@Controller
@Slf4j
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody //将所有的返回请求返回浏览器, 写在方法上只对方法有效
    public String hello() {
        log.info("Hello World!");
        return "Hello World!";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "你好");
        map.put("msg", "这是一条后台传入的信息");
        return "success";
    }
}
