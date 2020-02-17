package com.blackey.bbs.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.bbs.component.mapper.AccountInfoMapper;
import com.blackey.bbs.component.domain.AccountInfo;
import com.blackey.bbs.component.service.AccountInfoService;

import java.util.Map;

/**
 * 会员登录信息表 AccountInfoServiceImpl
 *
 * @author kaven
 * @date 2020-02-16 18:51:35
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
