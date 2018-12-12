package com.blackey.finance.component.service;

import com.blackey.finance.component.domain.WechatUserInfo;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 微信用户信息表 WechatUserInfoService
 *
 * @author kaven
 * @date 2018-12-07 13:53:50
 */
public interface WechatUserInfoService extends BaseService<WechatUserInfo> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

