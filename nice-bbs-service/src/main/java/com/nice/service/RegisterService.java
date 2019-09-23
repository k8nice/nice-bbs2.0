package com.nice.service;

import com.nice.domain.BbsUser;

/**
 * 注册逻辑接口
 * @author ningh
 */
public interface RegisterService {

    /**
     * 添加用户
     * @param bbsUser
     * @return
     */
    String addBbsUserService(BbsUser bbsUser);

    /**
     * 检测用户是否存在
     * @param bbsUserName
     * @return
     */
    Boolean checkBbsUserIsExist(String bbsUserName);

}
