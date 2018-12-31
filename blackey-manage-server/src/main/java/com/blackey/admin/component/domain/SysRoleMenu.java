package com.blackey.admin.component.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 角色与菜单对应关系
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Getter
@Setter
@TableName("sys_role_menu")
public class SysRoleMenu extends BaseModel<SysRoleMenu> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 角色ID
	 */
	private String roleId;
	/**
	 * 菜单ID
	 */
	private String menuId;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
        

}
