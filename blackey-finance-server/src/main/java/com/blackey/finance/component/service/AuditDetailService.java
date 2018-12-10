package com.blackey.finance.component.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.finance.component.domain.AuditDetail;
import com.blackey.finance.dto.form.AuditDetailForm;
import com.blackey.mybatis.service.BaseService;

/**
 * 审批详情表 AuditDetailService
 *
 * @author kaven
 * @date 2018-12-07 09:48:54
 */
public interface AuditDetailService extends BaseService<AuditDetail> {

    /**
    * 分页查询
    * @param form
    * @return
    */
    IPage<AuditDetail> queryPage(AuditDetailForm form, Page<AuditDetail> page);
}

