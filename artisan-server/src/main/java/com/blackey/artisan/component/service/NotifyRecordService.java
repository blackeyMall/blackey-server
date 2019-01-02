package com.blackey.artisan.component.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.artisan.component.domain.NotifyRecord;

import java.util.Map;

/**
 *  NotifyRecordService
 *
 * @author kaven
 * @date 2019-01-02 13:47:16
 */
public interface NotifyRecordService extends BaseService<NotifyRecord> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据openid 查询分页
     * @param openid
     * @param page
     * @return
     */
    Page<NotifyRecord> queryByOpenid(String openid, Page<NotifyRecord> page);
}

