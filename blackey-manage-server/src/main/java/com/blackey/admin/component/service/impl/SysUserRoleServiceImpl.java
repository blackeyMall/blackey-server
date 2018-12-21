package com.blackey.admin.component.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.admin.component.mapper.SysUserRoleMapper;
import com.blackey.admin.component.domain.SysUserRole;
import com.blackey.admin.component.service.SysUserRoleService;

import java.util.*;

/**
 * 用户与角色对应关系 SysUserRoleServiceImpl
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Service
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserRoleServiceImpl.class);

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysUserRole> page = (Page<SysUserRole>) this.page(
                new Query<SysUserRole>(params).getPage(),
                new QueryWrapper<SysUserRole>()
        );

        return new PageUtils(page);
    }

    /**
     * 删除用户角色关联
     *
     * @param roleIds
     */
    @Override
    public void deleteBatch(String[] roleIds) {
        baseMapper.deleteBatchIds(Arrays.asList(roleIds));
    }

    /**
     * 保存用户和角色关联关系
     *
     * @param userId 用户id
     * @param roleIdList
     */
    @Override
    public void saveOrUpdateUserRole(String userId, List<String> roleIdList) {

        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        //先删除用户与角色关系
        this.removeByMap(map);
        if(roleIdList == null || roleIdList.size() == 0){
            return ;
        }
        //保存用户与角色关系
        List<SysUserRole> list = new ArrayList<>(roleIdList.size());
        roleIdList.forEach(roleId -> {
            SysUserRole sysUserRoleEntity = new SysUserRole();
            sysUserRoleEntity.setUserId(userId);
            sysUserRoleEntity.setRoleId(roleId);
            list.add(sysUserRoleEntity);
        });
        this.saveBatch(list);
    }

    /**
     * 根据用户id查询角色信息
     *
     * @param createUserId
     * @return
     */
    //@Override
    public List<String> queryRoleIdList(String createUserId) {
        return null;
    }

}
