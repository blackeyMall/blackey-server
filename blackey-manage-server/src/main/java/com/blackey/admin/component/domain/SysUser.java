package com.blackey.admin.component.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.admin.global.constants.RoleEnum;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 系统用户
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Getter
@Setter
@TableName("sys_user")
public class SysUser extends BaseModel<SysUser> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 盐
	 */
	private String salt;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 状态  0：禁用   1：正常
	 */
	private Integer status;
	/**
	 * 租户ID
	 */
	private String tenantId;
	/**
	 * 登陆账号
	 */
	private String account;
	/**
	 * 角色类型
	 * @see RoleEnum
	 */
	private Integer roleType;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                

}
