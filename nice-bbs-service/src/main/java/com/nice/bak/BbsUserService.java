package com.nice.bak;

import com.nice.domain.BbsUser;

/**
 * @author ningh
 */
public interface BbsUserService {

    String addBbsUserService(BbsUser bbsUser);

    Boolean checkBbsUserIsExist(String bbsUserName);

    String loginBbsUser(String bbsUserName,String bbsUserPassword);

}
