package com.blackey.admin.dto;

import com.blackey.admin.component.domain.SysMenu;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * 导航菜单及用户权限
 * Created by Kaven
 * Date: 2018/6/5
 */
public class NavVO implements Serializable{

    private List<SysMenu> menuList;
    private Set<String> permissions ;

    public List<SysMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<SysMenu> menuList) {
        this.menuList = menuList;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }
}
