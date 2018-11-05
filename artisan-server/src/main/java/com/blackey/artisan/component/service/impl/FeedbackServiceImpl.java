package com.blackey.artisan.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.artisan.component.mapper.FeedbackMapper;
import com.blackey.artisan.component.domain.Feedback;
import com.blackey.artisan.component.service.FeedbackService;

import java.util.Map;

/**
 *  FeedbackServiceImpl
 *
 * @author kavenW
 * @date 2018-11-05 11:01:32
 */
@Service
public class FeedbackServiceImpl extends BaseServiceImpl<FeedbackMapper, Feedback> implements FeedbackService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<Feedback> page = (Page<Feedback>) this.page(
                new Query<Feedback>(params).getPage(),
                new QueryWrapper<Feedback>()
        );

        return new PageUtils(page);
    }

}
