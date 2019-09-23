package com.nice.service.impl;

import com.nice.commons.aes.Md5Utils;
import com.nice.domain.BbsUser;
import com.nice.mapper.BbsUserMapper;
import com.nice.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录业务实现类
 * @author ningh
 */
@Service
public class LoginServiceImpl implements LoginService {

    /**
     * 注入服务
     */
    @Autowired
    private BbsUserMapper bbsUserMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    /**
     * 登录用户
     * @param bbsUserName bbs用户名
     * @param bbsUserPassword bbs用户密码
     * @return  true or false
     */
    @Override
    public Boolean loginBbsUser(String bbsUserName, String bbsUserPassword) {
        //根据用户名取出密码和盐值
        BbsUser bbsUser = bbsUserMapper.queryBbsUserPasswordAndSaltByBbsUserName(bbsUserName);
        String salt = null ;
        try {
             salt = bbsUser.getSalt();
        } catch (NullPointerException exception) {
            LOGGER.error("发生空指针，堆栈信息为{}",exception.getStackTrace());
        }
        String bbsUserPassword1 = Md5Utils.getMd5Password(bbsUserPassword,salt);
        if (bbsUserPassword1.equals(bbsUser.getBbsUserPassword())){
            LOGGER.info("{}的密码验证通过",bbsUserName);
            return true;
        }
        return false;
    }
}
