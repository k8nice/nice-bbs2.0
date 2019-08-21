package com.nice.mapper;

import com.nice.NiceBbsDaoApplication;
import com.nice.domain.BbsUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * bbsUserMapper接口
 * @author ningh
 * @date 2019/8/22
 */
@Mapper
public interface BbsUserMapper {

    /**
     * 添加bbs用户
     * @param bbsUser
     */
    void addBbsUser(BbsUser bbsUser);

    /**
     * 根据bbs用户名查找bbs用户名
     * @param bbsUserName
     * @return  bbsUserName
     */
    String queryBbsUserNameByBbsUserName(String bbsUserName);

    /**
     * 根据bbs用户名查找bbs用户密码和盐值
     * @param bbsUserName
     * @return  bbsUserPassword
     */
    BbsUser queryBbsUserPasswordAndSaltByBbsUserName(String bbsUserName);

}
