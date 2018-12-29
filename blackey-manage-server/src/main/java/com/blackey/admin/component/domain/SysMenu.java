package com.blackey.admin.component.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单管理
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Getter
@Setter
@TableName("sys_menu")
public class SysMenu extends BaseModel<SysMenu> implements Serializable {

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

	/**
	 * ztree属性
	 */
	@TableField(exist=false)
	private Boolean open;

	@TableField(exist=false)
	private List<?> list;
	/**
	 * 父菜单名称
	 */
	@TableField(exist=false)
	private String parentName;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                            

}
