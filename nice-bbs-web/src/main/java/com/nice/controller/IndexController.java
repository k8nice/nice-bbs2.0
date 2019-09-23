package com.nice.controller;

import com.nice.domain.BbsUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 主页面
 * @author ningh
 */
@RequestMapping("/")
@Controller
public class IndexController {

    /**
     * 主页面为注册页面
     * @return  index
     */
    @GetMapping("/index")
    public String index(HttpServletRequest request){
        System.out.println("----------------index");
        BbsUser bbsUser  = (BbsUser) request.getSession().getAttribute("USER");
        request.setAttribute("bbsUser",bbsUser);
        return "html/index";
    }

}
