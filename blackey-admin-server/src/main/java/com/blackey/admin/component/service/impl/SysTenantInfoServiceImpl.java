package com.blackey.admin.component.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blackey.admin.dto.form.SysTenantInfoForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.admin.component.mapper.SysTenantInfoMapper;
import com.blackey.admin.component.domain.SysTenantInfo;
import com.blackey.admin.component.service.SysTenantInfoService;

import java.util.List;
import java.util.Map;

/**
 * 租户信息 SysTenantInfoServiceImpl
 *
 * @author kaven
 * @date 2018-12-12 11:23:05
 */
@Service
public class SysTenantInfoServiceImpl extends BaseServiceImpl<SysTenantInfoMapper, SysTenantInfo> implements SysTenantInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysTenantInfoServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysTenantInfo> page = (Page<SysTenantInfo>) this.page(
                new Query<SysTenantInfo>(params).getPage(),
                new QueryWrapper<SysTenantInfo>()
        );

        return new PageUtils(page);
    }

    /**
     * 分页查询
     *
     * @param form
     * @param page
     * @return
     */
    @Override
    public IPage<SysTenantInfo> listPage(SysTenantInfoForm form, Page<SysTenantInfo> page) {
        SysTenantInfo sysTenantInfo = new SysTenantInfo();
        BeanUtils.copyProperties(form,sysTenantInfo);

        return this.page(page, new QueryWrapper<SysTenantInfo>().setEntity(sysTenantInfo));


    }

}
