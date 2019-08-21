package com.nice.controller;

import com.nice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
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
     * 注入Service
     */
    @Autowired
    private LoginService loginService;

    /**
     * 返回登录页面
     * @return  login
     */
    @GetMapping("/index")
    public String index() {
        return "login";
    }

    /**
     * 登录认证
     * @param bbsUserName
     * @param bbsUserPassword
     * @return "main"
     */
    @PostMapping("/auth")
    public String loginBbsUser(String bbsUserName,String bbsUserPassword){
        loginService.loginBbsUser(bbsUserName,bbsUserPassword);
        //System.out.println(bbsUserName);
        //System.out.println(bbsUserPassword);
        return "main";
    }
}
