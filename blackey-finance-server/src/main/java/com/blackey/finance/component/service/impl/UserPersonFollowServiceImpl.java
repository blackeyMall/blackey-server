package com.blackey.finance.component.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.common.result.Result;
import com.blackey.finance.component.domain.UserPersonFollow;
import com.blackey.finance.component.domain.UserRelation;
import com.blackey.finance.component.mapper.UserPersonFollowMapper;
import com.blackey.finance.component.mapper.UserRelationMapper;
import com.blackey.finance.component.service.UserPersonFollowService;
import com.blackey.finance.dto.bo.UserPersonFollowBo;
import com.blackey.finance.dto.form.UserPersonFollowForm;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 用户关注用户表 UserPersonFollowServiceImpl
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Service
public class UserPersonFollowServiceImpl extends BaseServiceImpl<UserPersonFollowMapper, UserPersonFollow> implements UserPersonFollowService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserPersonFollowServiceImpl.class);

    @Resource
    private UserPersonFollowMapper userPersonFollowMapper;

    @Resource
    private UserRelationMapper userRelationMapper;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserPersonFollow> page = (Page<UserPersonFollow>) this.page(
                new Query<UserPersonFollow>(params).getPage(),
                new QueryWrapper<UserPersonFollow>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryByOpenid(UserPersonFollowForm form, Page page) {
        List<UserPersonFollowBo> userPersonFollowBos = userPersonFollowMapper.findUserFollowByOpenId(form,page);
        List<UserPersonFollowBo> resultBos = new ArrayList<>();

        for (UserPersonFollowBo userPersonFollowBo: userPersonFollowBos
             ) {
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("open_id",form.getOpenId());
            queryWrapper.eq("friend_id",userPersonFollowBo.getOpenId());
            UserRelation userRelation = userRelationMapper.selectOne(queryWrapper);
            if (userRelation != null){
                userPersonFollowBo.setIsAddFriend(1);
            }
            resultBos.add(userPersonFollowBo);
        }


        return new PageUtils(page.setRecords(resultBos));
    }

    @Override
    public Result foucsOrCancel(UserPersonFollowForm form) {
        QueryWrapper<UserPersonFollow> queryWrapper = new QueryWrapper();
        queryWrapper.eq("open_id",form.getOpenId());
        queryWrapper.eq("person_id",form.getPersonId());
        UserPersonFollow userPersonFollow = userPersonFollowMapper.selectOne(queryWrapper);

        if (userPersonFollow == null){
            userPersonFollow = new UserPersonFollow();
            userPersonFollow.setOpenId(form.getOpenId());
            userPersonFollow.setPersonId(form.getPersonId());
            userPersonFollowMapper.insert(userPersonFollow);
            return new Result(200,"已关注!",1);
        }

        userPersonFollowMapper.deleteById(userPersonFollow);
        return new Result(200,"取消关注!",0);
    }
}
