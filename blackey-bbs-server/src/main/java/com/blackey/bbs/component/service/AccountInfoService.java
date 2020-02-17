package com.blackey.bbs.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.bbs.component.domain.AccountInfo;

import java.util.Map;

/**
 * 会员登录信息表 AccountInfoService
 *
 * @author kaven
 * @date 2020-02-16 18:51:35
 */
public interface AccountInfoService extends BaseService<AccountInfo> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

