package com.blackey.admin.component.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 角色
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Getter
@Setter
@TableName("sys_role")
public class SysRole extends BaseModel<SysRole> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 租户ID
	 */
	private String tenantId;

	@TableField(exist=false)
	private List<String> menuIdList;

	@Override
    protected Serializable pkVal() {
        return this.getId();
    }
            

}
