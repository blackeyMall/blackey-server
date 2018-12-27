package com.blackey.finance.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.finance.component.mapper.AccountInfoMapper;
import com.blackey.finance.component.domain.AccountInfo;
import com.blackey.finance.component.service.AccountInfoService;

import java.util.Map;

/**
 * 账户信息表 AccountInfoServiceImpl
 *
 * @author kaven
 * @date 2018-12-07 09:48:54
 */
@Service
public class AccountInfoServiceImpl extends BaseServiceImpl<AccountInfoMapper, AccountInfo> implements AccountInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountInfoServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AccountInfo> page = (Page<AccountInfo>) this.page(
                new Query<AccountInfo>(params).getPage(),
                new QueryWrapper<AccountInfo>()
        );

        return new PageUtils(page);
    }

}
