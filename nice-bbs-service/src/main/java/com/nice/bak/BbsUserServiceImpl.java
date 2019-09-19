package com.nice.bak;

import com.nice.commons.aes.Md5Utils;
import com.nice.domain.BbsUser;
import com.nice.mapper.BbsUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author ningh
 */
@Service
public class BbsUserServiceImpl implements BbsUserService {

//    @SuppressWarnings("all")
    @Autowired
    private BbsUserMapper bbsUserMapper;

    @Override
    public String addBbsUserService(BbsUser bbsUser) {
        //判断两次输入密码是否一致
        if (bbsUser.getBbsUserPassword().equals(bbsUser.getBbsUserRepeatInputPassword())){
            bbsUser.setBbsUserIsActivate(false);
            bbsUser.setBbsUserIsLock(false);
            bbsUser.setBbsUserCreateDate(new Date());
            bbsUser.setBbsUserModifyDate(new Date());
            String salt = UUID.randomUUID().toString();
            bbsUser.setSalt(salt);
//            String bbsUserPassword = Md5Hash.
            //md5加密
            bbsUser.setBbsUserPassword(Md5Utils.getMd5Password(bbsUser.getBbsUserPassword(),salt));
            bbsUserMapper.addBbsUser(bbsUser);
        }
        else {
            return "error";
        }

//        bbsUser.setBbsUserPassword();
//        bbsUser.setSalt();
        return "success";
    }

    @Override
    public Boolean checkBbsUserIsExist(String bbsUserName) {
        String bbsUserName1 = bbsUserMapper.queryBbsUserNameByBbsUserName(bbsUserName);
        if (bbsUserName.equals(bbsUserName1)) {
            return true;
        }
        return false;
    }

    @Override
    public String loginBbsUser(String bbsUserName, String bbsUserPassword) {
        return null;
    }
}
