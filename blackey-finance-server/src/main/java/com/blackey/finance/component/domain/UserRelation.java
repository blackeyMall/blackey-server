package com.blackey.finance.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户好友关联表
 *
 * @author kaven
 * @date 2018-11-20 23:27:03
 */
@Getter
@Setter
@TableName("user_relation")
public class UserRelation extends BaseModel<UserRelation> implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * 
	 */
	private String userId;
	/**
	 * 
	 */
	private String friendId;
	/**
	 * 申请状态
	 */
	private String status;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                    

}
