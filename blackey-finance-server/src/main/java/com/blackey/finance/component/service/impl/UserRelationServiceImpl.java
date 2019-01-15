package com.blackey.finance.component.service.impl;

import com.blackey.common.result.Result;
import com.blackey.finance.component.mapper.UserPersonFollowMapper;
import com.blackey.finance.dto.bo.UserRelationBo;
import com.blackey.finance.dto.form.UserRelationForm;
import com.blackey.finance.global.constants.ApplyStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.finance.component.mapper.UserRelationMapper;
import com.blackey.finance.component.domain.UserRelation;
import com.blackey.finance.component.service.UserRelationService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 用户好友关联表 UserRelationServiceImpl
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Service
public class UserRelationServiceImpl extends BaseServiceImpl<UserRelationMapper, UserRelation> implements UserRelationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRelationServiceImpl.class);

    @Resource
    private UserRelationMapper userRelationMapper;

    @Resource
    private UserPersonFollowMapper userPersonFollowMapper;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserRelation> page = (Page<UserRelation>) this.page(
                new Query<UserRelation>(params).getPage(),
                new QueryWrapper<UserRelation>()
        );

        return new PageUtils(page);
    }

    @Override
    public Page queryPageByOpenId(UserRelationForm form, Page page) {
        List<UserRelationBo> userRelationBos = userRelationMapper.findUserRelationByOpenId(form,page);
        List<UserRelationBo> resultRelation = new ArrayList<>();

        for (UserRelationBo userRelation  :userRelationBos
             ) {
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("open_id",form.getOpenId());
            queryWrapper.eq("person_id",userRelation.getOpenId());
            if (userPersonFollowMapper.selectOne(queryWrapper) != null){
                userRelation.setIsFocus(1);
            }
            resultRelation.add(userRelation);
        }

        return page.setRecords(resultRelation);
    }


    @Override
    public Result addFriend(UserRelationForm userRelationForm) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("open_id",userRelationForm.getOpenId());
        queryWrapper.eq("friend_id",userRelationForm.getFriendId());
        queryWrapper.or();
        queryWrapper.eq("friend_id",userRelationForm.getOpenId());
        queryWrapper.eq("open_id",userRelationForm.getFriendId());
        UserRelation userRelation = userRelationMapper.selectOne(queryWrapper);

        if (userRelation == null){
            userRelation = new UserRelation();
            userRelation.setOpenId(userRelationForm.getOpenId());
            userRelation.setFriendId(userRelationForm.getFriendId());
            userRelation.setStatus(ApplyStatus.APPLY);
            userRelationMapper.insert(userRelation);
            return new Result(200,"添加好友成功");
        }
;
        return new Result(200,"不可重复添加");
    }


    @Override
    public void updateByFriend(UserRelationForm userRelationForm) {
        userRelationMapper.updateByFriend(userRelationForm);
    }

    /**
     * 查询好友申请的记录
     *
     * @param form
     * @param page
     * @return
     */
    @Override
    public Page queryApplyPageByOpenId(UserRelationForm form, Page page) {
        return page.setRecords(userRelationMapper.findUserApplyRelationByOpenId(form, page));
    }

    @Override
    public UserRelation findRelation(UserRelationForm form) {

        return userRelationMapper.findRelation(form);
    }

    @Override
    public void fakeDelete(UserRelationForm userRelationForm) {
        userRelationMapper.fakeDelete(userRelationForm);
    }
}
