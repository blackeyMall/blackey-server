package com.blackey.finance.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.finance.component.domain.UserRequireFollow;

import java.util.Map;

/**
 * 用户需求关注表 UserRequireFollowService
 *
 * @author kaven
 * @date 2018-11-20 23:27:03
 */
public interface UserRequireFollowService extends BaseService<UserRequireFollow> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

