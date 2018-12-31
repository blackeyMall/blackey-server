package com.blackey.tenant.component.service.impl;

import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.tenant.component.domain.SysRoleDept;
import com.blackey.tenant.component.mapper.SysRoleDeptMapper;
import com.blackey.tenant.component.service.SysRoleDeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 角色与部门对应关系 SysRoleDeptServiceImpl
 *
 * @author kavenW
 * @date 2018-06-29 14:18:32
 */
@Service
public class SysRoleDeptServiceImpl extends BaseServiceImpl<SysRoleDeptMapper, SysRoleDept> implements SysRoleDeptService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysRoleDeptServiceImpl.class);

    @Override
    public void saveOrUpdate(Long roleId, List<Long> deptIdList) {

    }

    @Override
    public List<Long> queryDeptIdList(Long[] roleIds) {
        return null;
    }

    @Override
    public int deleteBatch(Long[] roleIds) {
        return 0;
    }
}
