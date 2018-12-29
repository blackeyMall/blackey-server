package com.blackey.admin.component.service.impl;

import com.blackey.admin.component.domain.SysRoleMenu;
import com.blackey.admin.component.mapper.SysRoleMenuMapper;
import com.blackey.admin.component.service.SysRoleMenuService;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 角色与菜单对应关系 SysRoleMenuServiceImpl
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Service
public class SysRoleMenuServiceImpl extends BaseServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysRoleMenuServiceImpl.class);


    /**
     * 保存菜单角色
     *
     * @param roleId
     * @param menuIdList
     */
    @Override
    public void saveOrUpdate(String roleId, List<String> menuIdList) {

        //先删除角色与菜单关系
        deleteBatch(new String[]{roleId});

        if(menuIdList.size() == 0){
            return ;
        }

        //保存角色与菜单关系
        List<SysRoleMenu> list = new ArrayList<>(menuIdList.size());
        menuIdList.forEach(menuId -> {
            SysRoleMenu sysRoleMenuEntity = new SysRoleMenu();
            sysRoleMenuEntity.setMenuId(menuId);
            sysRoleMenuEntity.setRoleId(roleId);
            list.add(sysRoleMenuEntity);
        });
        this.saveBatch(list);
    }

    /**
     * 根据角色ID，获取菜单ID列表
     *
     * @param roleId
     * @return
     */
    @Override
    public List<String> queryMenuIdListByRoleId(String roleId) {

        return baseMapper.queryMenuIdListByRoleId(roleId);
    }

    /**
     * 根据角色ID数组，批量删除
     *
     * @param roleIds
     * @return
     */
    @Override
    public int deleteBatch(String[] roleIds) {
        return baseMapper.deleteBatchIds(Arrays.asList(roleIds));
    }
}
