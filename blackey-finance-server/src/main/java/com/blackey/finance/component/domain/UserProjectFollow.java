package com.blackey.finance.component.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 用户关注项目表
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Getter
@Setter
@TableName("t_user_project_follow")
public class UserProjectFollow extends BaseModel<UserProjectFollow> implements Serializable {

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

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
            

}
