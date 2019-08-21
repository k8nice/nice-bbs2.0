package com.nice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主页面
 * @author ningh
 */
@RequestMapping("/")
public class IndexController {

    /**
     * 主页面为注册页面
     * @return  index
     */
    @GetMapping
    public String index(){
        return "index";
    }

}
