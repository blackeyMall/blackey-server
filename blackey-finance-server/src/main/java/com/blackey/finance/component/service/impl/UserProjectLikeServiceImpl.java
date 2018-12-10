package com.blackey.finance.component.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.finance.component.domain.UserProjectLike;
import com.blackey.finance.component.mapper.UserProjectLikeMapper;
import com.blackey.finance.component.service.ProjectInfoService;
import com.blackey.finance.component.service.UserProjectLikeService;
import com.blackey.finance.dto.form.AddOrCancelFollowForm;
import com.blackey.finance.global.constants.AddCancelEnum;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 用户点赞项目表 UserProjectLikeServiceImpl
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Service
public class UserProjectLikeServiceImpl extends BaseServiceImpl<UserProjectLikeMapper, UserProjectLike> implements UserProjectLikeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserProjectLikeServiceImpl.class);

    @Autowired
    ProjectInfoService projectInfoService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserProjectLike> page = (Page<UserProjectLike>) this.page(
                new Query<UserProjectLike>(params).getPage(),
                new QueryWrapper<UserProjectLike>()
        );

        return new PageUtils(page);
    }

    /**
     * 点赞/取消点赞项目
     *
     * @param addOrCancelFollowForm
     * @return
     */
    @Override
    public boolean likeProject(AddOrCancelFollowForm addOrCancelFollowForm) {
        boolean flag ;
        AddCancelEnum addCancelEnum = AddCancelEnum.ADD;

        Wrapper<UserProjectLike> queryWrapper = new QueryWrapper();
        ((QueryWrapper<UserProjectLike>) queryWrapper)
                .eq("open_id",addOrCancelFollowForm.getOpenId())
                .eq("project_id",addOrCancelFollowForm.getObjectId());
        UserProjectLike userProjectLike = this.getOne(queryWrapper);

        if(userProjectLike == null){
            userProjectLike = new UserProjectLike();
            userProjectLike.setProjectId(addOrCancelFollowForm.getObjectId());
            userProjectLike.setOpenId(addOrCancelFollowForm.getOpenId());
            userProjectLike.setIsDeleted(0);
            this.save(userProjectLike);
        }else {
            if(AddCancelEnum.ADD.getValue().equals(addOrCancelFollowForm.getAddCancel())){
                userProjectLike.setIsDeleted(0);
            }else {
                userProjectLike.setIsDeleted(1);
                addCancelEnum = AddCancelEnum.CANCEL;
            }
            this.updateById(userProjectLike);

        }
        //点赞数加1或者减1
        flag = projectInfoService.addLikeNum(addOrCancelFollowForm.getObjectId(),addCancelEnum);

        return flag;

    }

}
