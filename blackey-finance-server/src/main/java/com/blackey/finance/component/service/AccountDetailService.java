package com.blackey.finance.component.service;

import com.blackey.finance.component.domain.AccountDetail;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 账户流水明细表 AccountDetailService
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
public interface AccountDetailService extends BaseService<AccountDetail> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

