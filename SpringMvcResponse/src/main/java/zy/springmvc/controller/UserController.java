package zy.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
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
        model.addAttribute(user.getUsername(), user);
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
        model.addAttribute(user.getUsername(), user);
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
        model.addAttribute(user.getUsername(), user);
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
        model.addAttribute(user.getUsername(), user);
        //如果没有返回值，则不会使用spring的视图解析器解析，
        // 第三种，直接相应，会有两次请求，第一个请求先发到请求的页面
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("你好");
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("执行testModelAndView方法...");
        //模拟从数据库中查询一个对象
        ModelAndView modelAndView = new ModelAndView();
        //功能一：可以把实体对象存入到ModelAndView实体类中，其也会把user对象存入到request域对象中
        User user = new User();
        user.setUsername("毒奶色");
        user.setAge(35);
        user.setPassword("********");
        modelAndView.addObject(user.getUsername(), user);
        //指定跳转页面
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/testForward")
    public String testForward() {
        System.out.println("执行testForward方法...");
        //使用关键字的方式实现转发或者重定向
        return "forward:/WEB-INF/pages/success.jsp";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect() {
        System.out.println("执行testRedirect方法...");
        //使用关键字的方式实现转发或者重定向
        //注意这里不再需要加项目的路径，框架自动会补上
        return "redirect:/index.jsp";
    }


    @RequestMapping("/testAjax")
    //相应ajax请求
    //注意返回的响应体是必须要加@ResponseBody才能返回数据，否则不会返回数据
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("执行testAjax方法..." + user);
        user.setAge(56);
        //响应结果
        return user;
    }
}
