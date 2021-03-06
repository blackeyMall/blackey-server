package com.blackey.tenant.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 租户信息 BO
 * 
 * @author kaven
 * @date 2018-12-12 11:23:05
 */
@Getter
@Setter
public class SysTenantInfoBo implements Serializable {

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

}
