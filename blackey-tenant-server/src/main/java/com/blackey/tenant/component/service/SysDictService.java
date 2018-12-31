package com.blackey.tenant.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.tenant.component.domain.SysDict;

import java.util.Map;


/**
 * 数据字典表 SysDictService
 *
 * @author kavenW
 * @date 2018-06-29 14:18:32
 */
public interface SysDictService extends BaseService<SysDict> {

    PageUtils queryPage(Map<String, Object> params);
}

