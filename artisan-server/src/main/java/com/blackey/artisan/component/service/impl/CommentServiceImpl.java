package com.blackey.artisan.component.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.artisan.component.domain.Comment;
import com.blackey.artisan.component.mapper.CommentMapper;
import com.blackey.artisan.component.service.CommentService;
import com.blackey.artisan.component.service.PictureInfoService;
import com.blackey.artisan.dto.bo.CommentBo;
import com.blackey.artisan.global.constants.PicTypeStatus;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;
import com.google.common.collect.Lists;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 *  CommentServiceImpl
 *
 * @author kaven
 * @date 2019-01-02 09:47:38
 */
@Service
public class CommentServiceImpl extends BaseServiceImpl<CommentMapper, Comment> implements CommentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Resource
    private PictureInfoService pictureInfoService;

    @Resource
    private CommentMapper commentMapper;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<Comment> page = (Page<Comment>) this.page(
                new Query<Comment>(params).getPage(),
                new QueryWrapper<Comment>()
        );

        return new PageUtils(page);
    }

    @Override
    public CommentBo getByServiceId(String serviceId) throws Exception{
        QueryWrapper<Comment> queryWrapper = new QueryWrapper();
        queryWrapper.eq("service_id", serviceId);
        Comment comment = commentMapper.selectOne(queryWrapper);
        CommentBo commentBo = new CommentBo();


        BeanUtils.copyProperties(commentBo, comment);
        List<String> pics = pictureInfoService.queryPicList(comment.getId(), PicTypeStatus.COMMENT);
        commentBo.setPicUrls(pics);

        return  commentBo;
    }

    @Override
    public Page<CommentBo> getByOpenid(String openid,Page page) throws InvocationTargetException, IllegalAccessException {
        List<CommentBo> commentBos = Lists.newArrayList();
        List<Comment> comments = commentMapper.getByOpenid(openid);

        for (Comment comment : comments) {
            CommentBo commentBo = new CommentBo();
            BeanUtils.copyProperties(commentBo, comment);

            List<String> pics = pictureInfoService.queryPicList(comment.getId(), PicTypeStatus.COMMENT);
            commentBo.setPicUrls(pics);
            commentBos.add(commentBo);
        }



        return page.setRecords(commentBos);
    }
}
