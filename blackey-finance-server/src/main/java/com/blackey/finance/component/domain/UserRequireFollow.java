package com.blackey.finance.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户需求关注表
 *
 * @author kaven
 * @date 2018-11-20 23:27:03
 */
@Getter
@Setter
@TableName("user_require_follow")
public class UserRequireFollow extends BaseModel<UserRequireFollow> implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 需求id
	 */
	private String requireId;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                

}