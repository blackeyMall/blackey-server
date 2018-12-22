package com.blackey.admin.component.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.admin.dto.form.SysTenantInfoForm;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.admin.component.domain.SysTenantInfo;

import java.util.List;
import java.util.Map;

/**
 * 租户信息 SysTenantInfoService
 *
 * @author kaven
 * @date 2018-12-12 11:23:05
 */
public interface SysTenantInfoService extends BaseService<SysTenantInfo> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 分页查询
     * @param form
     * @param page
     * @return
     */
    IPage<SysTenantInfo> listPage(SysTenantInfoForm form, Page<SysTenantInfo> page);
}

