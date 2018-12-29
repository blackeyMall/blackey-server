package com.blackey.admin.component.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 用户与角色对应关系
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Getter
@Setter
@TableName("sys_user_role")
public class SysUserRole extends BaseModel<SysUserRole> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 角色ID
	 */
	private String roleId;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
        

}
