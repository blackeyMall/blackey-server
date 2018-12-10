package com.blackey.finance.component.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.finance.component.domain.UserProjectFollow;
import com.blackey.finance.component.mapper.UserProjectFollowMapper;
import com.blackey.finance.component.service.ProjectInfoService;
import com.blackey.finance.component.service.UserProjectFollowService;
import com.blackey.finance.dto.bo.UserProjectFollowBo;
import com.blackey.finance.dto.form.AddOrCancelFollowForm;
import com.blackey.finance.dto.form.UserProjectFollowForm;
import com.blackey.finance.global.constants.AddCancelEnum;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 分页查询
     *
     * @param form
     * @param page
     * @return
     */
    @Override
    public List<UserProjectFollowBo> queryPage(UserProjectFollowForm form, Page<UserProjectFollowBo> page) {
        return baseMapper.queryPage(form,page);
    }

    /**
     * 关注项目
     *
     * @param addOrCancelFollowForm
     * @return
     */
    @Override
    public boolean followProject(AddOrCancelFollowForm addOrCancelFollowForm) {

        boolean flag ;
        AddCancelEnum addCancelEnum = AddCancelEnum.ADD;

        Wrapper<UserProjectFollow> queryWrapper = new QueryWrapper();
        ((QueryWrapper<UserProjectFollow>) queryWrapper)
                .eq("open_id",addOrCancelFollowForm.getOpenId())
                .eq("project_id",addOrCancelFollowForm.getObjectId());
        UserProjectFollow projectFollow = this.getOne(queryWrapper);

        if(projectFollow == null){
            projectFollow = new UserProjectFollow();
            projectFollow.setProjectId(addOrCancelFollowForm.getObjectId());
            projectFollow.setOpenId(addOrCancelFollowForm.getOpenId());
            projectFollow.setIsDeleted(0);
            this.save(projectFollow);
        }else {
            if(AddCancelEnum.ADD.getValue().equals(addOrCancelFollowForm.getAddCancel())){
                projectFollow.setIsDeleted(0);
            }else {
                projectFollow.setIsDeleted(1);
                addCancelEnum = AddCancelEnum.CANCEL;
            }
            this.updateById(projectFollow);
        }
        //关注数加1或者减1
        flag = projectInfoService.addFollowNum(addOrCancelFollowForm.getObjectId(),addCancelEnum);

        return flag;

    }
}
