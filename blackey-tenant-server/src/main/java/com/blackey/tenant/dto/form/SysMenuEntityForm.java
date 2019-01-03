package com.blackey.tenant.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * SysMenuEntityForm
 * Created by Kaven
 * Date: 2018/6/5
 */
@Getter
@Setter
public class SysMenuEntityForm implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    private Long menuId;

    /**
     * 父菜单ID，一级菜单为0
     */
    private Long parentId;

    /**
     * 父菜单名称
     */
    private String parentName;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单URL
     */
    private String url;

    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    private String perms;

    /**
     * 类型     0：目录   1：菜单   2：按钮
     */
    private Integer type;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer orderNum;
    /**
     * 是否系统菜单     0：否   1：是
     */
    private Integer isSystemMenu;

    /**
     * ztree属性
     */
    private Boolean open;

    private List<?> list;


}
