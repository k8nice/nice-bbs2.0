package com.nice.controller;

import com.nice.domain.BbsUser;
import com.nice.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    /**
     * 返回登录页面
     * @return  login
     */
    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        //如何用户的session不为null的话，直接跳转主页
        BbsUser bbsUser = (BbsUser) request.getSession().getAttribute("USER");

            if (bbsUser != null && bbsUser.getBbsUserName()!= null) {
                LOGGER.info("跳转到主页");
                return "redirect:/index";
            }

        //否则跳往登录页面
        return "login";
    }

    /**
     * 登录认证
     * @param bbsUserName 用户名
     * @param bbsUserPassword 密码
     * @return "/" or "login/index"
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
//            try {
//                request.getRequestDispatcher("../../index").forward(request, response);
//            } catch (ServletException | IOException e) {
//                e.printStackTrace();
//            }
            return "redirect:/index";
        }
        else {
            return "login/index";
        }
    }
}
