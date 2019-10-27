package com.nice.service;

import com.nice.domain.BbsInvitation;
import com.nice.domain.BbsInvitationType;

/**
 * 帖子管理服务接口
 * @author ningh
 */
public interface InvitationManageService {

    Boolean createBbsInvitationService(BbsInvitation bbsInvitation);

}
