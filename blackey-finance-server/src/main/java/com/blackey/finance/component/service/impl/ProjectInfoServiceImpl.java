package com.blackey.finance.component.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.common.exception.BusinessException;
import com.blackey.common.result.ResultCodeEnum;
import com.blackey.finance.component.domain.ProjectInfo;
import com.blackey.finance.component.domain.UserProjectFollow;
import com.blackey.finance.component.domain.UserProjectLike;
import com.blackey.finance.component.mapper.ProjectInfoMapper;
import com.blackey.finance.component.service.ProjectInfoService;
import com.blackey.finance.component.service.UserProjectFollowService;
import com.blackey.finance.component.service.UserProjectLikeService;
import com.blackey.finance.dto.bo.ProjectInfoBo;
import com.blackey.finance.dto.form.ProjectInfoForm;
import com.blackey.finance.global.constants.AddCancelEnum;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 项目信息表 ProjectInfoServiceImpl
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Service
public class ProjectInfoServiceImpl extends BaseServiceImpl<ProjectInfoMapper, ProjectInfo> implements ProjectInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectInfoServiceImpl.class);

    @Autowired
    UserProjectFollowService userProjectFollowService;

    @Autowired
    UserProjectLikeService userProjectLikeService;

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

    /**
     * 增加或减少点赞数量
     *
     * @param objectId
     * @param addCancelEnum
     * @return
     */
    @Override
    public boolean addLikeNum(String objectId, AddCancelEnum addCancelEnum) {
        ProjectInfo projectInfo = this.getById(objectId);
        if(projectInfo == null){
            throw new BusinessException(ResultCodeEnum.NOT_FOUND);
        }
        if(AddCancelEnum.ADD == addCancelEnum){
            projectInfo.setLikeNum(projectInfo.getLikeNum() + 1);
        }else {
            projectInfo.setLikeNum(projectInfo.getLikeNum() - 1);
        }
        return this.updateById(projectInfo);
    }

    /**
     * 分页查询--所有项目
     *
     * @param form
     * @param page
     * @return
     */
    @Override
    public List<ProjectInfoBo> listAllPage(ProjectInfoForm form, Page<ProjectInfoBo> page) {

        List<ProjectInfoBo> projectInfoBos = baseMapper.listAllPage(form, page);
        if(CollectionUtils.isEmpty(projectInfoBos)){
            return null;
        }
        String openId;
        String projectId;
        for (ProjectInfoBo projectInfoBo : projectInfoBos){
            openId = projectInfoBo.getOpenId();
            projectId = projectInfoBo.getId();
            List<UserProjectFollow> userProjectFollows = userProjectFollowService.list(new QueryWrapper<UserProjectFollow>().eq("open_id", openId)
                    .eq("project_id", projectId));
            if(!CollectionUtils.isEmpty(userProjectFollows)){
                //已关注
                projectInfoBo.setIsFollow(AddCancelEnum.ADD);
            }

            List<UserProjectLike> userProjectLikes = userProjectLikeService.list(new QueryWrapper<UserProjectLike>().eq("open_id", openId)
                    .eq("project_id", projectId));
            if(!CollectionUtils.isEmpty(userProjectLikes)){
                //已点赞
                projectInfoBo.setIsLike(AddCancelEnum.ADD);
            }

        }
        return projectInfoBos;
    }
}
