package com.blackey.finance.component.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.blackey.finance.component.domain.UserProjectLike;
import com.blackey.finance.component.domain.UserRequireFollow;
import com.blackey.finance.component.service.RequirementInfoService;
import com.blackey.finance.dto.form.AddOrCancelFollowForm;
import com.blackey.finance.global.constants.AddCancelEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.finance.component.mapper.UserRequireLikeMapper;
import com.blackey.finance.component.domain.UserRequireLike;
import com.blackey.finance.component.service.UserRequireLikeService;

import java.util.Map;

/**
 * 用户需求点赞表 UserRequireLikeServiceImpl
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Service
public class UserRequireLikeServiceImpl extends BaseServiceImpl<UserRequireLikeMapper, UserRequireLike> implements UserRequireLikeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRequireLikeServiceImpl.class);


    @Autowired
    RequirementInfoService requirementInfoService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserRequireLike> page = (Page<UserRequireLike>) this.page(
                new Query<UserRequireLike>(params).getPage(),
                new QueryWrapper<UserRequireLike>()
        );

        return new PageUtils(page);
    }

    /**
     * 点赞
     *
     * @param form
     * @return
     */
    @Override
    public boolean likeRequire(AddOrCancelFollowForm form) {
        boolean flag ;
        AddCancelEnum addCancelEnum = AddCancelEnum.ADD;

        Wrapper<UserRequireLike> queryWrapper = new QueryWrapper();
        ((QueryWrapper<UserRequireLike>) queryWrapper)
                .eq("open_id",form.getOpenId())
                .eq("require_id",form.getObjectId());
        UserRequireLike userRequireLike = this.getOne(queryWrapper);

        if(userRequireLike == null){
            userRequireLike = new UserRequireLike();
            userRequireLike.setRequireId(form.getObjectId());
            userRequireLike.setOpenId(form.getOpenId());
            userRequireLike.setIsDeleted(0);
            this.save(userRequireLike);
        }else {
            if(AddCancelEnum.ADD.getValue().equals(form.getAddCancel())){
                userRequireLike.setIsDeleted(0);
            }else {
                userRequireLike.setIsDeleted(1);
                addCancelEnum = AddCancelEnum.CANCEL;
            }
            this.updateById(userRequireLike);
        }
        //关注数加1或者减1
        flag = requirementInfoService.addLikeNum(form.getObjectId(),addCancelEnum);

        return flag;
    }

}
