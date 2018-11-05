package com.blackey.artisan.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.artisan.component.domain.Feedback;

import java.util.Map;

/**
 *  FeedbackService
 *
 * @author kavenW
 * @date 2018-11-05 11:01:32
 */
public interface FeedbackService extends BaseService<Feedback> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

