package com.nice.service;

/**
 * 登录服务接口
 * @author ningh
 * @date 2019/08/22 6:20
 */
public interface LoginService {
    /**
     * 登录用户
     * @param bbsUserName bbs用户名
     * @param bbsUserPassword bbs用户密码
     * @return true or false
     */
    Boolean loginBbsUser(String bbsUserName,String bbsUserPassword);
}
