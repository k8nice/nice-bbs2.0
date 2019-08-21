package com.nice.service.impl;

import com.nice.domain.BbsUser;
import com.nice.mapper.BbsUserMapper;
import com.nice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private BbsUserMapper bbsUserMapper;

    /**
     * 登录用户
     * @param bbsUserName bbs用户名
     * @param bbsUserPassword bbs用户密码
     * @return  true or false
     */
    @Override
    public Boolean loginBbsUser(String bbsUserName, String bbsUserPassword) {
        BbsUser bbsUser = bbsUserMapper.queryBbsUserPasswordAndSaltByBbsUserName(bbsUserName);
        String salt = bbsUser.getSalt();
        //未写完
        return null;
    }
}
