package com.blackey.finance.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户关注用户表
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Getter
@Setter
@TableName("t_user_person_follow")
public class UserPersonFollow extends BaseModel<UserPersonFollow> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	@TableId
	private String openId;
	/**
	 * 被关注人id
	 */
	private String personId;
	/**
	 * 备注
	 */
	private String remark;

    @Override
    protected Serializable pkVal() {
        return this.getOpenId();
    }
            

}
