package com.blackey.finance.dto.form;

import com.blackey.finance.global.constants.ApplyStatus;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户好友关联表 Form表单
 * 
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Getter
@Setter
public class UserRelationForm implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
	/**
	 * 用户id
	 */
    private String openId;
	/**
	 * 朋友id
	 */
    private String friendId;
	/**
	 * 申请状态（通过，拒绝，待同意）
	 */
    private ApplyStatus status;
	/**
	 * 备注
	 */
    private String remark;

}
