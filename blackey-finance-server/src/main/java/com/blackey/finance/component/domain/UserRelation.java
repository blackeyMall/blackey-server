package com.blackey.finance.component.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 用户好友关联表
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Getter
@Setter
@TableName("t_user_relation")
public class UserRelation extends BaseModel<UserRelation> implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                

}
