package com.blackey.flowers.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.flowers.component.domain.UserInfo;

import java.util.Map;

/**
 * 用户信息表 UserInfoService
 *
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
public interface UserInfoService extends BaseService<UserInfo> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

