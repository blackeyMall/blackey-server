package com.blackey.finance.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.finance.component.domain.UserProjectFollow;

import java.util.Map;

/**
 * 用户关注项目表 UserProjectFollowService
 *
 * @author kaven
 * @date 2018-11-20 23:27:03
 */
public interface UserProjectFollowService extends BaseService<UserProjectFollow> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

