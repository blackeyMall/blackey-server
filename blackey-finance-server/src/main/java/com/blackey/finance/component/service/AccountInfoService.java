package com.blackey.finance.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.finance.component.domain.AccountInfo;

import java.util.Map;

/**
 * 账户信息表 AccountInfoService
 *
 * @author kaven
 * @date 2018-12-07 09:48:54
 */
public interface AccountInfoService extends BaseService<AccountInfo> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

