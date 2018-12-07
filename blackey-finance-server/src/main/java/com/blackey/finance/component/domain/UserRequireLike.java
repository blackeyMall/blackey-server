package com.blackey.finance.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
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
public class UserRequireLike extends BaseModel<UserRequireLike> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	@TableId
	private String openId;
	/**
	 * 需求id
	 */
	private String requireId;
	/**
	 * 备注
	 */
	private String remark;

    @Override
    protected Serializable pkVal() {
        return this.getOpenId();
    }
            

}
