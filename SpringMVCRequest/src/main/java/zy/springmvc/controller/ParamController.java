package zy.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zy.springmvc.entity.Account;
import zy.springmvc.entity.User;

@Controller
//注意这里RequestMapping不写path也可以传一个路径进去
@RequestMapping("/param")
public class ParamController {
    @RequestMapping("/testParam")
    public String testParam(String username, String password) {
        System.out.println("执行了testParam方法....");
        System.out.println("用户名：" + username + "\n密码：" + password);
        return "success";
    }

    //把数据封装到javaBean的类中
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        System.out.println("执行了testParam方法....");
        System.out.println("用户信息：" + account.toString());
        return "success";
    }

    //自定义类型转换器
    @RequestMapping("/saveUser")
    public String saveUser(User user) {
        System.out.println("执行了testParam方法....");
        System.out.println("用户信息：" + user.toString());
        return "success";
    }
}
