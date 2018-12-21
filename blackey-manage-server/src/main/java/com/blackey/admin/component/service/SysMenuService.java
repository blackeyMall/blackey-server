package com.blackey.admin.component.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blackey.admin.dto.form.SysMenuForm;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.admin.component.domain.SysMenu;

import java.util.List;
import java.util.Map;

/**
 * 菜单管理 SysMenuService
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
public interface SysMenuService extends BaseService<SysMenu> {

    /**
    * 分页查询
    * @param form
     * @param page
    * @return
    */
    IPage<SysMenu> queryPage(SysMenuForm form,IPage<SysMenu> page);
    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     * @param menuIdList  用户菜单ID
     * @return list
     */
    List<SysMenu> queryListParentId(String parentId, List<String> menuIdList);

    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     * @return list
     */
    List<SysMenu> queryListParentId(String parentId);

    /**
     * 获取不包含按钮的菜单列表
     * @return list
     */
    List<SysMenu> queryNotButtonList();

    /**
     * 获取用户菜单列表
     * @param userId
     * @return list
     */
    List<SysMenu> getUserMenuList(String userId);

    /**
     * 删除
     * @param menuId
     */
    void delete(String menuId);
}

