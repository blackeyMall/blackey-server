package com.blackey.finance.component.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.blackey.common.exception.BusinessException;
import com.blackey.common.result.ResultCodeEnum;
import com.blackey.finance.dto.bo.ProjectInfoBo;
import com.blackey.finance.dto.form.ProjectInfoForm;
import com.blackey.finance.global.constants.AddCancelEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.finance.component.mapper.ProjectInfoMapper;
import com.blackey.finance.component.domain.ProjectInfo;
import com.blackey.finance.component.service.ProjectInfoService;

import java.util.List;
import java.util.Map;

/**
 * 项目信息表 ProjectInfoServiceImpl
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Service
public class ProjectInfoServiceImpl extends BaseServiceImpl<ProjectInfoMapper, ProjectInfo> implements ProjectInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectInfoServiceImpl.class);


    /**
     * 分页查询
     *
     * @param form
     * @param page
     * @return
     */
    @Override
    public List<ProjectInfoBo> queryPage(ProjectInfoForm form, Page<ProjectInfoBo> page) {

        return baseMapper.queryPage(form,page);
    }

    /**
     * 增加或减少关注数量
     *
     * @param objectId
     * @param addCancelEnum
     * @return
     */
    @Override
    public boolean addFollowNum(String objectId, AddCancelEnum addCancelEnum) {

        ProjectInfo projectInfo = this.getById(objectId);
        if(projectInfo == null){
            throw new BusinessException(ResultCodeEnum.NOT_FOUND);
        }
        if(AddCancelEnum.ADD == addCancelEnum){
            projectInfo.setFollowNum(projectInfo.getFollowNum() + 1);
        }else {
            projectInfo.setFollowNum(projectInfo.getFollowNum() - 1);
        }
        return this.updateById(projectInfo);

    }
}
