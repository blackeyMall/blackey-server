package com.blackey.tenant.component.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.blackey.tenant.component.domain.SysMenuEntity;
import com.blackey.tenant.component.domain.SysRoleMenuEntity;
import com.blackey.tenant.component.mapper.SysMenuMapper;
import com.blackey.tenant.component.service.SysMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.tenant.component.mapper.SysTenantMenuMapper;
import com.blackey.tenant.component.domain.SysTenantMenu;
import com.blackey.tenant.component.service.SysTenantMenuService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 租户菜单关联表 SysTenantMenuServiceImpl
 *
 * @author kaven
 * @date 2018-12-22 14:33:05
 */
@Service
public class SysTenantMenuServiceImpl extends BaseServiceImpl<SysTenantMenuMapper, SysTenantMenu> implements SysTenantMenuService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysTenantMenuServiceImpl.class);

    @Autowired
    SysMenuService sysMenuService;

    /**
     * 根据角色ID，获取菜单列表
     *
     * @param tenantId
     * @return
     */
    @Override
    public List<SysMenuEntity> queryMenuListByTenantId(Long tenantId) {

        List<SysMenuEntity> sysMenuEntities = sysMenuService.queryMenuByTenantId(tenantId);

        return sysMenuEntities;
    }

    /**
     * 保存/更新租户菜单
     *
     * @param tenantId
     * @param menuIdList
     */
    @Override
    public void saveOrUpdateTenantMenu(Long tenantId, List<Long> menuIdList) {

        baseMapper.delete(new UpdateWrapper<SysTenantMenu>()
                .eq("tenant_id",tenantId));

        if(menuIdList.size() == 0){
            return ;
        }
        //保存租户与菜单关系
        List<SysTenantMenu> list = new ArrayList<>(menuIdList.size());
        menuIdList.forEach(menuId -> {
            SysTenantMenu sysTenantMenu = new SysTenantMenu();
            sysTenantMenu.setMenuId(menuId);
            sysTenantMenu.setTenantId(tenantId);
            list.add(sysTenantMenu);
        });
        this.saveBatch(list);
    }

    /**
     * 查询菜单id
     *
     * @param id
     * @return
     */
    @Override
    public List<Long> queryMenuIdByTenantId(Long id) {

        return baseMapper.queryMenuIdByTenantId(id);
    }
}
