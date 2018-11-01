package com.blackey.admin.component.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.admin.component.domain.SysDept;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 部门管理 SysDeptService
 *
 * @author kavenW
 * @date 2018-06-29 14:18:31
 */
public interface SysDeptService extends BaseService<SysDept> {

    PageUtils queryPage(Map<String, Object> params);

    List<SysDept> queryList(Map<String, Object> map);

    /**
     * 查询子部门ID列表
     * @param parentId  上级部门ID
     */
    List<Long> queryDetpIdList(Long parentId);

    /**
     * 获取子部门ID，用于数据过滤
     */
    List<Long> getSubDeptIdList(Long deptId);
}

