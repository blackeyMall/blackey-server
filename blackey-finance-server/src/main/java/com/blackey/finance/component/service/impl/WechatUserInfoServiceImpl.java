package com.blackey.finance.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.finance.component.mapper.WechatUserInfoMapper;
import com.blackey.finance.component.domain.WechatUserInfo;
import com.blackey.finance.component.service.WechatUserInfoService;

import java.util.Map;

/**
 * 微信用户信息表 WechatUserInfoServiceImpl
 *
 * @author kaven
 * @date 2018-12-07 13:53:50
 */
@Service
public class WechatUserInfoServiceImpl extends BaseServiceImpl<WechatUserInfoMapper, WechatUserInfo> implements WechatUserInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatUserInfoServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WechatUserInfo> page = (Page<WechatUserInfo>) this.page(
                new Query<WechatUserInfo>(params).getPage(),
                new QueryWrapper<WechatUserInfo>()
        );

        return new PageUtils(page);
    }

}
