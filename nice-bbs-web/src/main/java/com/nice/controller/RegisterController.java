package com.nice.controller;

import com.nice.domain.BbsUser;
import com.nice.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 注册Controller类
 * @author ningh
 */
@RequestMapping
@Controller
public class RegisterController {

    //@SuppressWarnings("all")
    @Autowired
    private RegisterService registerService;

    @GetMapping("/register/index")
    public String registerPage(){
        return "register";
    }

    /**
     * 注册用户
     * @param bbsUser
     * @return
     */
    @PostMapping("/register")
    @ResponseBody
    public String registerBbsUser(BbsUser bbsUser){
        System.out.println(bbsUser);
        registerService.addBbsUserService(bbsUser);
        return "success";
    }

    /**
     * 检查用户是否存在
     * @param bbsUserName
     * @return
     */
    @GetMapping("/check/user/is/exist")
    @ResponseBody
    public Boolean checkBbsUserIsExist(String bbsUserName){
        //如果用户存在返回true,否则返回false
        if (registerService.checkBbsUserIsExist(bbsUserName)){
            return true;
        }
        return false;
    }

}
