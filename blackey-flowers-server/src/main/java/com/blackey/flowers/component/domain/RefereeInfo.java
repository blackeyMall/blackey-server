package com.blackey.flowers.component.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 
 *
 * @author kaven
 * @date 2018-11-28 20:43:34
 */
@Getter
@Setter
@TableName("t_referee_info")
public class RefereeInfo extends BaseModel<RefereeInfo> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 推荐人姓名
	 */
	private String name;
	/**
	 * 渠道来源
	 */
	private String channel;

    @Override
    protected Serializable pkVal() {
        return this.getName();
    }
        

}
