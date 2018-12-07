package com.blackey.finance.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.finance.component.domain.UserInfo;

import java.util.Map;

/**
 * 用户信息表 UserInfoService
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
public interface UserInfoService extends BaseService<UserInfo> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

