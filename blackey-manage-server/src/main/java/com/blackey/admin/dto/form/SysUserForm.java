package com.blackey.admin.dto.form;

import com.baomidou.mybatisplus.annotation.TableField;
import com.blackey.admin.dto.BaseSearch;
import com.blackey.admin.global.constants.RoleEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统用户 Form表单
 * 
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Getter
@Setter
public class SysUserForm extends BaseSearch implements Serializable {

    private static final long serialVersionUID = 1L;
	/**
	 * 用户名
	 */
    private String userName;
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

    private String createdBy;
	/**
	 * 角色类型
	 * @see RoleEnum
	 */
	private Integer roleType;


}
