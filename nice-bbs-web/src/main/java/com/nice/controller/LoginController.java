package com.nice.controller;

import com.nice.domain.BbsUser;
import com.nice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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
     * @param bbsUserName 用户名
     * @param bbsUserPassword 密码
     * @return "main"
     */
    @PostMapping("/auth")
    public String loginBbsUser(String bbsUserName, String bbsUserPassword, HttpServletRequest request){
        boolean b =  loginService.loginBbsUser(bbsUserName,bbsUserPassword);
        //System.out.println(bbsUserName);
        //System.out.println(bbsUserPassword);
        BbsUser bbsUser = new BbsUser();
        if (b) {
            bbsUser.setBbsUserName(bbsUserName);
            //设置session
            request.getSession().setAttribute("USER", bbsUser);
            return "main";
        }
        else {
            return "login/index";
        }
    }
}
