package com.blackey.finance.component.service;

import com.blackey.finance.component.domain.UserProjectLike;
import com.blackey.finance.dto.form.AddOrCancelFollowForm;
import com.blackey.finance.global.constants.AddCancelEnum;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 用户点赞项目表 UserProjectLikeService
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
public interface UserProjectLikeService extends BaseService<UserProjectLike> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 点赞/取消点赞项目
     * @param addOrCancelFollowForm
     * @return
     */
    AddCancelEnum likeProject(AddOrCancelFollowForm addOrCancelFollowForm);
}

