package com.nice.domain;
import lombok.Data;

import	java.util.Date;

import java.io.Serializable;

/**
 * 帖子类型实体类
 * @author ningh
 */
@Data
public class BbsInvitationType implements Serializable {

    /**
     * 帖子类型id
     */
    private Long bbsInvitationTypeId;

    /**
     * 帖子类型名称
     */
    private String bbsInvitationTypeName;

    /**
     * 帖子类型创建时间
     */
    private Date bbsInvitationTypeCreateDate;

    /**
     * 帖子类型更新时间
     */
    private Date bbsInvitationTypeModifyDate;

    /**
     * bbs帖子类型备注
     */
    private String bbsInvitationTypeRemark;

    /**
     * 用户id（创建人）
     */
    private Long bbsUserId;

}
