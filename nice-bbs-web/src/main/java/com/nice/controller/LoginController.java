package com.nice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录Controller类
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    /**
     * 返回登录页面
     * @return  login
     */
    @GetMapping("/index")
    public String index() {
        return "login";
    }

    @PostMapping("/auth")
    public String loginBbsUser(String bbsUserName,String bbsUserPassword){
        System.out.println(bbsUserName);
        System.out.println(bbsUserPassword);
        return "main";
    }
}
