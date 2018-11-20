package com.blackey.finance.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.finance.component.domain.Account;

import java.util.Map;

/**
 * 账户信息表 AccountService
 *
 * @author kaven
 * @date 2018-11-20 23:27:02
 */
public interface AccountService extends BaseService<Account> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

