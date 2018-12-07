package com.blackey.finance.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.finance.component.domain.UserProjectLike;

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
}

