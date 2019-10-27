package com.nice.controller;
import com.nice.domain.BbsUser;
import com.nice.mapper.BbsInvitationTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
     * 注入mapper实例
     */
    @Autowired
    private BbsInvitationTypeMapper bbsInvitationTypeMapper;

    /**
     * 添加文章页面
     * @return "redirect:/invitation/add" 添加帖子页面
     */
    @GetMapping("/add/page")
    public String addInvitationPage(HttpServletRequest request){
        //获取session中的用户信息
        BbsUser bbsUser  = (BbsUser) request.getSession().getAttribute("USER");
        //把用户信息写入request作用域中
        request.setAttribute("bbsUser",bbsUser);
        request.setAttribute("bbsInvitationDefaultType", bbsInvitationTypeMapper.queryBbsInvitationTypeAll());
        return "/invitation/add";
    }

}
