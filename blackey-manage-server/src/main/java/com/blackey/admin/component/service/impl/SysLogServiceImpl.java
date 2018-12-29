package com.blackey.admin.component.service.impl;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.admin.component.mapper.SysLogMapper;
import com.blackey.admin.component.domain.SysLog;
import com.blackey.admin.component.service.SysLogService;

import java.util.Map;

/**
 * 系统日志 SysLogServiceImpl
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Service
public class SysLogServiceImpl extends BaseServiceImpl<SysLogMapper, SysLog> implements SysLogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysLogServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        String key = (String)params.get("key");

        Page<SysLog> page = (Page<SysLog>) this.page(
                new Query<SysLog>(params).getPage(),
                new QueryWrapper<SysLog>().like(StringUtils.isNotBlank(key),"username", key)
        );

        return new PageUtils(page);
    }

}
