package com.blackey.admin.component.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blackey.admin.component.domain.SysUser;
import com.blackey.admin.component.service.SysRoleMenuService;
import com.blackey.admin.component.service.SysUserService;
import com.blackey.admin.dto.form.SysMenuForm;
import com.blackey.admin.global.constants.MenuEnum;
import com.blackey.admin.global.constants.RoleEnum;
import com.blackey.common.exception.BusinessException;
import com.blackey.common.result.ResultCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.admin.component.mapper.SysMenuMapper;
import com.blackey.admin.component.domain.SysMenu;
import com.blackey.admin.component.service.SysMenuService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单管理 SysMenuServiceImpl
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysMenuServiceImpl.class);

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;


    /**
     * 分页查询
     *
     * @param form
     * @param page
     * @return
     */
    @Override
    public IPage<SysMenu> queryPage(SysMenuForm form, IPage<SysMenu> page) {
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tenant_id",form.getTenantId());
        queryWrapper.orderByDesc("created_date");
        return baseMapper.selectPage(page,queryWrapper);
    }

    /**
     * 根据父菜单，查询子菜单
     *
     * @param parentId   父菜单ID
     * @param menuIdList 用户菜单ID
     * @return list
     */
    @Override
    public List<SysMenu> queryListParentId(String parentId, List<String> menuIdList) {
        List<SysMenu> menuList = queryListParentId(parentId);
        if(menuIdList == null){
            return menuList;
        }

        List<SysMenu> userMenuList = new ArrayList<>();
        for(SysMenu menu : menuList){
            if(menuIdList.contains(menu.getId())){
                userMenuList.add(menu);
            }
        }
        return userMenuList;
    }

    /**
     * 根据父菜单，查询子菜单
     *
     * @param parentId 父菜单ID
     * @return list
     */
    @Override
    public List<SysMenu> queryListParentId(String parentId) {

        List<SysMenu> sysMenus = baseMapper.selectList(new QueryWrapper<SysMenu>()
                .eq("parent_id", parentId)
                .orderByAsc("order_num"));

        return sysMenus;
    }

    /**
     * 获取不包含按钮的菜单列表
     *
     * @return list
     */
    @Override
    public List<SysMenu> queryNotButtonList() {
        List<SysMenu> sysMenus = baseMapper.selectList(new QueryWrapper<SysMenu>().ne("type", MenuEnum.BUTTON.getCode())
                .orderByAsc("order_num"));
        return sysMenus;
    }

    /**
     * 获取用户菜单列表
     *
     * @param userId
     * @return list
     */
    @Override
    public List<SysMenu> getUserMenuList(String userId) {

        SysUser sysUser = sysUserService.getById(userId);
        if(null == sysUser){
            throw new BusinessException(ResultCodeEnum.NOT_FOUND);
        }
        //系统管理员，拥有最高权限
        if(sysUser.getRoleType() == RoleEnum.ROLE_SUPER.getCode()){
            return getAllMenuList(null);
        }

        //用户菜单列表
        List<String> menuIdList = sysUserService.queryAllMenuIdByUserId(userId);
        return getAllMenuList(menuIdList);
    }

    /**
     * 删除
     *
     * @param menuId
     */
    @Override
    public void delete(String menuId) {
        //删除菜单
        this.removeById(menuId);
        Map<String,Object> map = new HashMap<>();
        map.put("menu_id", menuId);
        //删除菜单与角色关联
        sysRoleMenuService.removeByMap(map);
    }



    /**
     * 获取所有菜单列表
     */
    private List<SysMenu> getAllMenuList(List<String> menuIdList){
        //查询根菜单列表
        List<SysMenu> menuList = queryListParentId("0", menuIdList);
        //递归获取子菜单
        getMenuTreeList(menuList, menuIdList);

        return menuList;
    }

    /**
     * 递归
     */
    private List<SysMenu> getMenuTreeList(List<SysMenu> menuList, List<String> menuIdList){
        List<SysMenu> subMenuList = new ArrayList<>();

        for(SysMenu entity : menuList){
            //目录
            if(entity.getType() == MenuEnum.CATALOG.getCode()){
                entity.setList(getMenuTreeList(queryListParentId(entity.getId(), menuIdList), menuIdList));
            }
            subMenuList.add(entity);
        }

        return subMenuList;
    }
}
