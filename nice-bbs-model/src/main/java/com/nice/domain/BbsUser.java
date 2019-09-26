package com.nice.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * bbs用户实体类
 */
@Data
public class BbsUser implements Serializable {

    /**
     * 用户Id
     */
    private    Long    bbsUserId;

    /**
     * 用户姓名
     */
    private     String  bbsUserName;

    /**
     * 用户密码
     */
    private     String  bbsUserPassword;

    /**
     * 用户密码确认
     */
    private     String  bbsUserRepeatInputPassword;

    /**
     *用户真实姓名
     */
    private     String  bbsUserRealName;

    /**
     * 用户地址
     */
    private     String  bbsUserAddress;

    /**
     * 用户性别
     */
    private     String  bbsUserGender;

    /**
     * 用户电话
     */
    private     String  bbsUserMobile;

    /**
     * 用户出生日期
     */
    private     String    bbsUserBirth;

    /**
     * 用户邮箱
     */
    private     String  bbsUserEmail;

    /**
     * 用户创建时间
     */
    private     Date    bbsUserCreateDate;

    /**
     * 用户修改时间
     */
    private     Date    bbsUserModifyDate;

    /**
     * 用户是否激活
     */
    private     Boolean bbsUserIsActivate;

    /**
     * 账户是否锁定
     */
    private     Boolean bbsUserIsLock;

    /**
     * 盐值
     */
    private     String  salt;




}
