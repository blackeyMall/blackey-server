package com.blackey.finance.component.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.finance.component.domain.UserRequireFollow;
import com.blackey.finance.component.mapper.UserRequireFollowMapper;
import com.blackey.finance.component.service.RequirementInfoService;
import com.blackey.finance.component.service.UserRequireFollowService;
import com.blackey.finance.dto.bo.UserRequireFollowBo;
import com.blackey.finance.dto.form.AddOrCancelFollowForm;
import com.blackey.finance.dto.form.UserRequireFollowForm;
import com.blackey.finance.global.constants.AddCancelEnum;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户需求关注表 UserRequireFollowServiceImpl
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Service
public class UserRequireFollowServiceImpl extends BaseServiceImpl<UserRequireFollowMapper, UserRequireFollow> implements UserRequireFollowService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRequireFollowServiceImpl.class);


    @Autowired
    RequirementInfoService requirementInfoService;
    /**
     * 分页查询
     *
     * @param form
     * @param page
     * @return
     */
    @Override
    public List<UserRequireFollowBo> queryPage(UserRequireFollowForm form, Page<UserRequireFollowBo> page) {
        return baseMapper.queryPage(form,page);
    }

    /**
     * 取消或关注需求
     *
     * @param form
     * @return
     */
    @Override
    public AddCancelEnum addFollowNum(AddOrCancelFollowForm form) {

        AddCancelEnum addCancelEnum = AddCancelEnum.ADD;

        QueryWrapper<UserRequireFollow> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("open_id",form.getOpenId())
                .eq("require_id",form.getObjectId())
                .orderByDesc("created_date");
        UserRequireFollow userRequireFollow = this.getOne(queryWrapper);

        if(userRequireFollow == null){
            userRequireFollow = new UserRequireFollow();
            userRequireFollow.setRequireId(form.getObjectId());
            userRequireFollow.setOpenId(form.getOpenId());
            this.save(userRequireFollow);
        }else {
            this.removeById(userRequireFollow.getId());
            addCancelEnum = AddCancelEnum.CANCEL;
        }
        //关注数加1或者减1
        requirementInfoService.addFollowNum(form.getObjectId(),addCancelEnum);

        return addCancelEnum;
    }
}
