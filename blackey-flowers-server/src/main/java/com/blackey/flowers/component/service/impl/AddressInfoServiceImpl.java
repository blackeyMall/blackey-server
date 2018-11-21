package com.blackey.flowers.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.flowers.component.mapper.AddressInfoMapper;
import com.blackey.flowers.component.domain.AddressInfo;
import com.blackey.flowers.component.service.AddressInfoService;

import java.util.Map;

/**
 * 收货地址信息表 AddressInfoServiceImpl
 *
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
@Service
public class AddressInfoServiceImpl extends BaseServiceImpl<AddressInfoMapper, AddressInfo> implements AddressInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressInfoServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AddressInfo> page = (Page<AddressInfo>) this.page(
                new Query<AddressInfo>(params).getPage(),
                new QueryWrapper<AddressInfo>()
        );

        return new PageUtils(page);
    }

}
