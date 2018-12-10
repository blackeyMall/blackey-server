package com.blackey.finance.component.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.finance.component.domain.AuditDetail;
import com.blackey.finance.component.mapper.AuditDetailMapper;
import com.blackey.finance.component.service.AuditDetailService;
import com.blackey.finance.dto.form.AuditDetailForm;
import com.blackey.finance.global.constants.AuditStatusEnum;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 审批详情表 AuditDetailServiceImpl
 *
 * @author kaven
 * @date 2018-12-07 09:48:54
 */
@Service
public class AuditDetailServiceImpl extends BaseServiceImpl<AuditDetailMapper, AuditDetail> implements AuditDetailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuditDetailServiceImpl.class);


    /**
     * 分页查询
     *
     * @param form
     * @param page
     * @return
     */
    @Override
    public IPage<AuditDetail> queryPage(AuditDetailForm form, Page<AuditDetail> page) {


        Wrapper<AuditDetail> queryWrapper = new QueryWrapper();
        if(StringUtils.isNotBlank(form.getObjectType().getValue())){
            ((QueryWrapper<AuditDetail>) queryWrapper).eq("object_type",form.getAuditStatus());
        }
        if(StringUtils.isNotBlank(form.getAuditBy())){
            ((QueryWrapper<AuditDetail>) queryWrapper).eq("audit_by",form.getAuditBy());
        }
        if(null != form.getAuditStatus()){
            ((QueryWrapper<AuditDetail>) queryWrapper).eq("audit_status",form.getAuditStatus());
        }else {
            ((QueryWrapper<AuditDetail>) queryWrapper).eq("audit_status", AuditStatusEnum.WAITING);
        }
        ((QueryWrapper<AuditDetail>) queryWrapper).orderByDesc("created_date");

        IPage<AuditDetail> auditDetailIPage = this.page(page, queryWrapper);

        return auditDetailIPage;
    }
}
