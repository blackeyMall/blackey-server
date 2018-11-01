package com.blackey.admin.component.service.impl;

import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.admin.component.domain.SysDict;
import com.blackey.admin.component.mapper.SysDictMapper;
import com.blackey.admin.component.service.SysDictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * 数据字典表 SysDictServiceImpl
 *
 * @author kavenW
 * @date 2018-06-29 14:18:32
 */
@Service
public class SysDictServiceImpl extends BaseServiceImpl<SysDictMapper, SysDict> implements SysDictService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysDictServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }
}
