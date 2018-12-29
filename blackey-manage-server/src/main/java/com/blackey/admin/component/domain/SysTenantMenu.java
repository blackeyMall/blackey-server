package com.blackey.admin.component.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Getter
@Setter
@TableName("sys_tenant_menu")
public class SysTenantMenu extends BaseModel<SysTenantMenu> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 租户id
	 */
	private String tenantId;
	/**
	 * 菜单id
	 */
	private String menuId;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
        

}
