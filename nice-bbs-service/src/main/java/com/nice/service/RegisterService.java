package com.nice.service;

import com.nice.domain.BbsUser;

public interface RegisterService {

    String addBbsUserService(BbsUser bbsUser);

    Boolean checkBbsUserIsExist(String bbsUserName);

}
