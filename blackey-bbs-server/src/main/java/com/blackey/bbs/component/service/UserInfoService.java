package com.blackey.bbs.component.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.bbs.component.domain.UserInfo;

import java.util.Map;

/**
 * 会员用户信息表 UserInfoService
 *
 * @author kaven
 * @date 2020-02-16 18:51:35
 */
public interface UserInfoService extends BaseService<UserInfo> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    IPage queryPage(Map<String, Object> params);
}

