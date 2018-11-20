package com.blackey.finance.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.finance.component.mapper.AccountMapper;
import com.blackey.finance.component.domain.Account;
import com.blackey.finance.component.service.AccountService;

import java.util.Map;

/**
 * 账户信息表 AccountServiceImpl
 *
 * @author kaven
 * @date 2018-11-20 23:27:02
 */
@Service
public class AccountServiceImpl extends BaseServiceImpl<AccountMapper, Account> implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<Account> page = (Page<Account>) this.page(
                new Query<Account>(params).getPage(),
                new QueryWrapper<Account>()
        );

        return new PageUtils(page);
    }

}
