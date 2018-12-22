package com.blackey.admin.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.admin.component.mapper.SysTenantMenuMapper;
import com.blackey.admin.component.domain.SysTenantMenu;
import com.blackey.admin.component.service.SysTenantMenuService;

import java.util.Map;

/**
 * 租户菜单关联表 SysTenantMenuServiceImpl
 *
 * @author kaven
 * @date 2018-12-22 14:33:05
 */
@Service
public class SysTenantMenuServiceImpl extends BaseServiceImpl<SysTenantMenuMapper, SysTenantMenu> implements SysTenantMenuService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysTenantMenuServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysTenantMenu> page = (Page<SysTenantMenu>) this.page(
                new Query<SysTenantMenu>(params).getPage(),
                new QueryWrapper<SysTenantMenu>()
        );

        return new PageUtils(page);
    }

}
