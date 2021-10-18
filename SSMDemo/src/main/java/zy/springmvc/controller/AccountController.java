package zy.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zy.springmvc.domain.Account;
import zy.springmvc.service.AccountService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Account> result = accountService.findAll();
        System.out.println("查询结果..." + result);
        model.addAttribute("list", result);
        return "list";
    }

    @RequestMapping("/save")
    public String save(Account account, Model model) {
        accountService.saveAccount(account);
        System.out.println("保存结果..." + account);
        List<Account> result = new ArrayList<>();
        result.add(account);
        model.addAttribute("list", result);
        return "list";
    }

//    @RequestMapping("/save")
//    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        accountService.saveAccount(account);
//        response.sendRedirect(request.getContextPath() + "/account/findAll");
//    }
}
