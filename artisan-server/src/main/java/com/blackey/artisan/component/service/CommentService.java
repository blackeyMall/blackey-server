package com.blackey.artisan.component.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.artisan.component.domain.Comment;
import com.blackey.artisan.dto.bo.CommentBo;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 *  CommentService
 *
 * @author kaven
 * @date 2019-01-02 09:47:38
 */
public interface CommentService extends BaseService<Comment> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 通过service id 查询评论详情
     * @param serviceId
     * @return
     */
    CommentBo getByServiceId(String serviceId) throws Exception;

    /**
     * 通过openid查询
     * @param openid
     * @return
     */
    Page<CommentBo> getByOpenid(String openid,Page page);


}

