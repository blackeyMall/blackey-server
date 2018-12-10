package com.blackey.finance.component.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户需求点赞表
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Getter
@Setter
@TableName("t_user_require_like")
public class UserRequireLike implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId
	private String id;

	@TableField(fill = FieldFill.INSERT)
	private Integer isDeleted;

	@TableField(fill = FieldFill.INSERT)
	private Date createdDate;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updatedDate;

	@TableField(fill = FieldFill.INSERT)
	private String createdBy;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String updatedBy;
	/**
	 * 用户id
	 */
	private String openId;
	/**
	 * 需求id
	 */
	private String requireId;
	/**
	 * 备注
	 */
	private String remark;

    protected Serializable pkVal() {
        return this.getId();
    }
            

}
