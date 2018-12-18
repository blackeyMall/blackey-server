package com.blackey.admin.component.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 租户信息
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Getter
@Setter
@TableName("sys_tenant_info")
public class SysTenantInfo extends BaseModel<SysTenantInfo> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 手机号
	 */
	private String telephone;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 法人姓名
	 */
	private String legalPerson;
	/**
	 * 公司名称
	 */
	private String company;
	/**
	 * 职位
	 */
	private String duties;
	/**
	 * 公司简介
	 */
	private String companyBrief;
	/**
	 * 公司官网
	 */
	private String companyWebsite;
	/**
	 * 公司地址
	 */
	private String companyAddress;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                

}
