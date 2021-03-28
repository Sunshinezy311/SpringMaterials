package zy.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zy.springmvc.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("执行testString方法...");
        //模拟从数据库中查询一个对象
        User user = new User();
        user.setUsername("韩美娟");
        user.setAge(25);
        user.setPassword("********");
        model.addAttribute("韩美娟", user);
        return "success";
    }

    @RequestMapping("/testVoidByForward")
    public void testVoidByForward(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
        System.out.println("执行testString方法...");
        //模拟从数据库中查询一个对象
        User user = new User();
        user.setUsername("韩美娟");
        user.setAge(25);
        user.setPassword("********");
        model.addAttribute("韩美娟", user);
        //如果没有返回值，则不会使用spring的视图解析器解析，
        // 第一种，请求转发流程，只有一次请求，注意只能自己写入完整路径
        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
    }

    @RequestMapping("/testVoid1ByRedirect")
    public void testVoid1ByRedirect(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
        System.out.println("执行testString方法...");
        //模拟从数据库中查询一个对象
        User user = new User();
        user.setUsername("韩美娟");
        user.setAge(25);
        user.setPassword("********");
        model.addAttribute("韩美娟", user);
        //如果没有返回值，则不会使用spring的视图解析器解析，
        // 第二种，重定向方式，会有两次请求，第一个请求先发到请求的页面
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    @RequestMapping("/testVoid1ByDirect")
    public void testVoid1ByDirect(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
        System.out.println("执行testString方法...");
        //模拟从数据库中查询一个对象
        User user = new User();
        user.setUsername("韩美娟");
        user.setAge(25);
        user.setPassword("********");
        model.addAttribute("韩美娟", user);
        //如果没有返回值，则不会使用spring的视图解析器解析，
        // 第三种，直接相应，会有两次请求，第一个请求先发到请求的页面
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("你好");
    }
}
