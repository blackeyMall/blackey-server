package com.blackey.tenant.component.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.tenant.component.domain.SysDept;
import com.blackey.tenant.component.mapper.SysDeptMapper;
import com.blackey.tenant.component.service.SysDeptService;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * 部门管理 SysDeptServiceImpl
 *
 * @author kavenW
 * @date 2018-06-29 14:18:31
 */
@Service
public class SysDeptServiceImpl extends BaseServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysDeptServiceImpl.class);


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String name = (String)params.get("name");
        Long createUserId = (Long)params.get("createUserId");

        Page<SysDept> page = (Page<SysDept>) this.page(
                new Query<SysDept>(params).getPage(),
                new QueryWrapper<SysDept>()
                        .like(StringUtils.isNotBlank(name),"name", name)
        );

        return new PageUtils(page);
    }

    @Override
    public List<SysDept> queryList(Map<String, Object> map) {

        return baseMapper.selectByMap(map);
    }

    @Override
    public List<Long> queryDetpIdList(Long parentId) {
        return null;
    }

    @Override
    public List<Long> getSubDeptIdList(Long deptId) {
        return null;
    }
}
