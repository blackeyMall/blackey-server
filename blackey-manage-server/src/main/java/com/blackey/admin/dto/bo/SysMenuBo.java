package com.blackey.admin.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜单管理 BO
 * 
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Getter
@Setter
public class SysMenuBo implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 父菜单ID，一级菜单为0
	 */
    private String parentId;
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
	 * 类型   0：目录   1：菜单   2：按钮
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

}
