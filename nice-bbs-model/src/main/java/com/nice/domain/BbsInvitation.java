package com.nice.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 帖子实体类
 * @author ningh
 */
@Data
public class BbsInvitation {

    /**
     * 帖子id
     */
    private Long bbsInvitationId;

    /**
     * 帖子名称
     */
    private String bbsInvitationName;

    /**
     * 帖子内容
     */
    private String bbsInvitationContent;

    /**
     * 帖子类型
     */
    private String bbsInvitationType;

    /**
     * 帖子创建时间
     */
    private Date bbsInvitationCreateDate;

    /**
     * 帖子修改时间
     */
    private Date bbsInvitationModifyDate;

    /**
     * 用户id
     */
    private Long bbsUserId;

    /**
     * 被邀请人的id
     */
    private List<Long> bbsInviteUserId;

    /**
     * 是否锁定
     */
    private Boolean isLock;


}
