package com.blackey.finance.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.finance.component.mapper.AccountDetailMapper;
import com.blackey.finance.component.domain.AccountDetail;
import com.blackey.finance.component.service.AccountDetailService;

import java.util.Map;

/**
 * 账户流水明细表 AccountDetailServiceImpl
 *
 * @author kaven
 * @date 2018-11-20 23:27:02
 */
@Service
public class AccountDetailServiceImpl extends BaseServiceImpl<AccountDetailMapper, AccountDetail> implements AccountDetailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountDetailServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AccountDetail> page = (Page<AccountDetail>) this.page(
                new Query<AccountDetail>(params).getPage(),
                new QueryWrapper<AccountDetail>()
        );

        return new PageUtils(page);
    }

}
