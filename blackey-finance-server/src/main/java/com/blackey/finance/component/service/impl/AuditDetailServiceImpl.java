package com.blackey.finance.component.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.finance.component.domain.AuditDetail;
import com.blackey.finance.component.domain.ProjectInfo;
import com.blackey.finance.component.domain.RequirementInfo;
import com.blackey.finance.component.mapper.AuditDetailMapper;
import com.blackey.finance.component.service.AuditDetailService;
import com.blackey.finance.component.service.ProjectInfoService;
import com.blackey.finance.component.service.RequirementInfoService;
import com.blackey.finance.dto.bo.AuditDetailBo;
import com.blackey.finance.dto.form.AuditDetailForm;
import com.blackey.finance.global.constants.AuditStatusEnum;
import com.blackey.finance.global.constants.ObjectTypeEnum;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 审批详情表 AuditDetailServiceImpl
 *
 * @author kaven
 * @date 2018-12-07 09:48:54
 */
@Service
public class AuditDetailServiceImpl extends BaseServiceImpl<AuditDetailMapper, AuditDetail> implements AuditDetailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuditDetailServiceImpl.class);

    @Autowired
    RequirementInfoService requirementInfoService;

    @Autowired
    ProjectInfoService projectInfoService;

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
            ((QueryWrapper<AuditDetail>) queryWrapper).eq("object_type",form.getObjectType());
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

    /**
     * 记录审批
     *
     * @param auditDetail
     */
    @Override
    public void audit(AuditDetail auditDetail) {

        this.updateById(auditDetail);
        String id = auditDetail.getObjectId();
        //项目审批
        if(ObjectTypeEnum.PROJECT.getValue().equals(auditDetail.getObjectType().getValue())){
            ProjectInfo projectInfo = new ProjectInfo();
            projectInfo.setId(id);
            projectInfo.setAuditStatus(auditDetail.getAuditStatus());
            projectInfoService.update(projectInfo,new UpdateWrapper<ProjectInfo>().eq("id",auditDetail.getObjectId()));
        }
        //需求审批
        if(ObjectTypeEnum.REQUIRE.getValue().equals(auditDetail.getObjectType().getValue())){
            RequirementInfo requirementInfo = new RequirementInfo();
            requirementInfo.setId(id);
            requirementInfo.setAuditStatus(auditDetail.getAuditStatus());
            requirementInfoService.update(requirementInfo,new UpdateWrapper<RequirementInfo>().eq("id",auditDetail.getObjectId()));
        }

    }

    /**
     * 分页查询审批记录
     *
     * @param form
     * @param page
     * @return
     */
    @Override
    public List<AuditDetailBo> queryListPage(AuditDetailForm form, Page<AuditDetailBo> page) {

        List<AuditDetailBo> detailBoList;
        if(ObjectTypeEnum.REQUIRE == form.getObjectType()){
            detailBoList = baseMapper.queryRequireAuditListPage(form,page);
        }else {
            detailBoList = baseMapper.queryProjectAuditListPage(form,page);
        }

        return detailBoList;
    }
}
