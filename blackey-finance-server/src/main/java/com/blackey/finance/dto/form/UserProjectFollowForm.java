package com.blackey.finance.dto.form;

import com.blackey.finance.dto.BaseSearch;
import com.blackey.finance.global.constants.OrderbyEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户关注项目表 Form表单
 * 
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Getter
@Setter
public class UserProjectFollowForm extends BaseSearch implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
    private String openId;
	/**
	 * 项目id
	 */
    private String projectId;
	/**
	 * 备注
	 */
    private String remark;
	/**
	 * 排序方式
	 */
	private OrderbyEnum orderbyEnum = OrderbyEnum.DEFAULT;

}
