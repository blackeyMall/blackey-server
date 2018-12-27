package com.blackey.finance.component.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.finance.component.domain.UserProjectFollow;
import com.blackey.finance.component.domain.UserProjectLike;
import com.blackey.finance.component.mapper.UserProjectFollowMapper;
import com.blackey.finance.component.service.ProjectInfoService;
import com.blackey.finance.component.service.UserProjectFollowService;
import com.blackey.finance.component.service.UserProjectLikeService;
import com.blackey.finance.dto.bo.ProjectInfoBo;
import com.blackey.finance.dto.form.AddOrCancelFollowForm;
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
 * 用户关注项目表 UserProjectFollowServiceImpl
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Service
public class UserProjectFollowServiceImpl extends BaseServiceImpl<UserProjectFollowMapper, UserProjectFollow> implements UserProjectFollowService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserProjectFollowServiceImpl.class);

    @Autowired
    ProjectInfoService projectInfoService;

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

        List<ProjectInfoBo> projectInfoBos = baseMapper.queryPage(form,page);
        if(CollectionUtils.isEmpty(projectInfoBos)){
            return null;
        }
        String openId = form.getOpenId();
        String projectId;
        for (ProjectInfoBo projectInfoBo : projectInfoBos){
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

    /**
     * 关注项目
     *
     * @param addOrCancelFollowForm
     * @return
     */
    @Override
    public AddCancelEnum followProject(AddOrCancelFollowForm addOrCancelFollowForm) {

        AddCancelEnum addCancelEnum = AddCancelEnum.ADD;

        Wrapper<UserProjectFollow> queryWrapper = new QueryWrapper();
        ((QueryWrapper<UserProjectFollow>) queryWrapper)
                .eq("open_id",addOrCancelFollowForm.getOpenId())
                .eq("project_id",addOrCancelFollowForm.getObjectId())
                .orderByDesc("created_date");
        UserProjectFollow projectFollow = this.getOne(queryWrapper);

        if(projectFollow == null){
            projectFollow = new UserProjectFollow();
            projectFollow.setProjectId(addOrCancelFollowForm.getObjectId());
            projectFollow.setOpenId(addOrCancelFollowForm.getOpenId());
            this.save(projectFollow);
        }else {
            this.removeById(projectFollow.getId());
            addCancelEnum = AddCancelEnum.CANCEL;
        }
        //关注数加1或者减1
        projectInfoService.addFollowNum(addOrCancelFollowForm.getObjectId(),addCancelEnum);

        return addCancelEnum;

    }
}
