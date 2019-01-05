package com.blackey.artisan.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.artisan.component.mapper.NotifyRecordMapper;
import com.blackey.artisan.component.domain.NotifyRecord;
import com.blackey.artisan.component.service.NotifyRecordService;

import javax.annotation.Resource;
import java.util.Map;

/**
 *  NotifyRecordServiceImpl
 *
 * @author kaven
 * @date 2019-01-02 13:47:16
 */
@Service
public class NotifyRecordServiceImpl extends BaseServiceImpl<NotifyRecordMapper, NotifyRecord> implements NotifyRecordService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotifyRecordServiceImpl.class);

    @Resource
    private NotifyRecordMapper notifyRecordMapper;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NotifyRecord> page = (Page<NotifyRecord>) this.page(
                new Query<NotifyRecord>(params).getPage(),
                new QueryWrapper<NotifyRecord>()
        );

        return new PageUtils(page);
    }

    @Override
    public Page<NotifyRecord> queryByOpenid(String openid, Page<NotifyRecord> page) {
        QueryWrapper<NotifyRecord> queryWrapper = new QueryWrapper<NotifyRecord>();
        queryWrapper.eq("notify_user_openid",openid);

        return page.setRecords(notifyRecordMapper.selectList(queryWrapper));
    }

}
