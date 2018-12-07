package com.blackey.finance.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.finance.component.domain.UserPersonFollow;

import java.util.Map;

/**
 * 用户关注用户表 UserPersonFollowService
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
public interface UserPersonFollowService extends BaseService<UserPersonFollow> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

