package com.blackey.artisan.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.artisan.component.mapper.ShareRelationMapper;
import com.blackey.artisan.component.domain.ShareRelation;
import com.blackey.artisan.component.service.ShareRelationService;

import javax.annotation.Resource;
import java.util.Map;

/**
 *  ShareRelationServiceImpl
 *
 * @author kaven
 * @date 2019-01-02 13:47:16
 */
@Service
public class ShareRelationServiceImpl extends BaseServiceImpl<ShareRelationMapper, ShareRelation> implements ShareRelationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShareRelationServiceImpl.class);

    @Resource
    ShareRelationMapper shareRelationMapper;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShareRelation> page = (Page<ShareRelation>) this.page(
                new Query<ShareRelation>(params).getPage(),
                new QueryWrapper<ShareRelation>()
        );

        return new PageUtils(page);
    }


    @Override
    public String exsitParent(String openid) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("friend_openid",openid);
        ShareRelation shareRelation = shareRelationMapper.selectOne(queryWrapper);

        if (shareRelation != null){
            return shareRelation.getUserOpenid();
        }

        return "";
    }
}
