package zy.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(path = "/user")
public class HelloController {

    @RequestMapping(path = "/hello")
    public String sayHello() {
        System.out.println("Hello Spring MVC!");
        //返回的字符串，很根据springmvc.xml中配置的视图解析器中使用的路径，匹配对应jsp文件的名称
        return "success";
    }

    // value和path是一样的
    // method如果和发过来的请求不匹配，则会报405
    @RequestMapping(method = {POST, GET}, value = "/testRequestMapping")
    public String testRequestMapping() {
        System.out.println("测试RequestMapping注解........");
        return "success";
    }

    // params必须传入参数才行，否则会报400或者404
    @RequestMapping(method = {POST, GET}, value = "/testRequestMappingWithParams", params = {"username=coolkie"})
    public String testRequestMappingWithParams() {
        System.out.println("测试RequestMapping注解........");
        return "success";
    }

    // params必须传入参数才行，否则会报400或者404
    @RequestMapping(method = {POST, GET}, value = "/testRequestMappingWithParams1", params = {"username=coolkie"})
    public String testRequestMappingWithParams1() {
        System.out.println("测试RequestMapping注解........注意走的是这个请求！！！而不是上面的");
        return "success";
    }

    // headers是表示必须包含这个头的属性
    @RequestMapping(headers = {"Accept"}, method = {POST, GET}, value = "/testRequestMappingWithParamsAndHeaders", params = {"username=coolkie"})
    public String testRequestMappingWithParamsAndHeaders() {
        System.out.println("测试RequestMapping注解........注意走的是这个请求！！！而不是上面的");
        return "success";
    }

    // Servlet原生API介绍
    @RequestMapping("/servletOriginApi")
    public String servletOriginApi() {
        System.out.println("测试servletOriginApi注解.......");
        return "originServlet";
    }

    // Spring发送Post请求的传参方式介绍
    @RequestMapping("/postRequest")
    public String postRequest() {
        System.out.println("测试postRequest注解.......");
        return "params";
    }
}
