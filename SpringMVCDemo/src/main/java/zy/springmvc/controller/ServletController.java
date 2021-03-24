package zy.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import zy.springmvc.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

//Servlet原生API调用
@Controller
//注意不能用name，name是找不到路径的
@RequestMapping(path = "/originServlet")
@SessionAttributes(value = {"msg"}) //相当于把testSessionAttributes中配置的msg=美美存入到Session对象中一份，这样的话方法之间可以共享
public class ServletController {
    @RequestMapping(path = "/servletTest")
    public String servletTest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行Servlet原生API" + request);
        System.out.println("执行Servlet原生API" + response);
        HttpSession session = request.getSession();
        System.out.println(session);
        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);
        return "success";
    }

    @RequestMapping(path = "/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username) {
        System.out.println("testRequestParam：" + username);
        return "success";
    }

    //返回的是body是个请求体，不是body字段的值
    @RequestMapping(path = "/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("testRequestBody：" + body);
        return "success";
    }

    //restful风格的请求。不用再指定path路径，根据
    @RequestMapping(path = "/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id) {
        System.out.println("testPathVariable：" + id);
        return "success";
    }

    //基于HiddentHttpMethodFilter过滤器示例

    //基于RequestHeader，获取请求头的值
    @RequestMapping(path = "/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header) {
        System.out.println("testRequestHeader：" + header);
        return "success";
    }


    //获取网页Cookie
    @RequestMapping(path = "/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue) {
        System.out.println("testCookieValue：" + cookieValue);
        return "success";
    }

    //获取网页Cookie
    @RequestMapping(path = "/testModelAttribute")
    public String testModelAttribute(@ModelAttribute(name = "张三") User user) {
        System.out.println("testModelAttribute执行了...." + user.toString());
        return "success";
    }

    //有返回值的处理方法, 注解加在方法上即可
    @ModelAttribute
    public User initUserBySetters(String uname) {
        System.out.println("initUserBySetters()执行了...表单中没有的值，可以在showUser方法里补");
        User user = new User();
        user.setUname("张三");
        user.setAge(23);
        user.setDate(new Date());
        System.out.println(user);
        return user;
    }

    //无返回值的处理方法，注解要加到方法和处理请求的参数上。
    // 注意，有返回值和无返回值不要同时使用，会导致设置的值不生效
    @ModelAttribute
    public void initUserByMap(String uname, Map<String, User> map) {
        System.out.println("initUserByMap()执行了...表单中没有的值，可以在showUser方法里补");
        User user = new User();
        user.setUname("张三");
        user.setAge(24);
        user.setDate(new Date());
        System.out.println(user);
        map.put("张三", user);
    }

    //SessionAttributes值存储
    @RequestMapping(path = "/setSessionAttributes")
    public String setSessionAttributes(Model model) {
        //直接用HttpServletRequest也可以存对象，但是耦合度太高
        model.addAttribute("msg", "美美");
        System.out.println("setSessionAttributes...." + model);
        //success.jsp中可以取到msg中的数据
        return "success";
    }

    //SessionAttributes值共享
    @RequestMapping(path = "/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap) {
        //直接用HttpServletRequest也可以存对象，但是耦合度太高
        String msg = String.valueOf(modelMap.get("msg"));
        System.out.println("getSessionAttributes...." + msg);
        //success.jsp中可以取到msg中的数据
        return "success";
    }

    //SessionAttributes删除共享值
    @RequestMapping(path = "/deleteSessionAttributes")
    public String deleteSessionAttributes(SessionStatus status) {
        System.out.println("deleteSessionAttributes....");
        //直接用HttpServletRequest也可以存对象，但是耦合度太高
        status.setComplete();

        //success.jsp中可以取到msg中的数据
        return "success";
    }
}
