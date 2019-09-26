package com.nice.controller;
import com.nice.domain.BbsUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


/**
 * 帖子相关(控制层)
 * @author ningh
 * @date 2019/09/24
 */
@Controller
@RequestMapping("/invitation")
public class InvitationController {

    /**
     * 添加文章页面
     * @return "redirect:/invitation/add" 添加帖子页面
     */
    @GetMapping("/add/page")
    public String addInvitationPage(HttpServletRequest request){
        BbsUser bbsUser  = (BbsUser) request.getSession().getAttribute("USER");
        request.setAttribute("bbsUser",bbsUser);
        return "/invitation/add";
    }

}
