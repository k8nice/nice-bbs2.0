package com.nice.mapper;

import com.nice.domain.BbsInvitationType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * bbs帖子类型mapper接口
 * @author ningh
 */
@Mapper
public interface BbsInvitationTypeMapper {

    List<String> queryBbsInvitationTypeAll();

}
