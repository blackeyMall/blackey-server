package com.blackey.artisan.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author kavenW
 * @date 2018-11-04 21:12:23
 */
@Getter
@Setter
@TableName("user")
public class User extends BaseModel<User> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	private String city;
	/**
	 *
	 */
	private String country;
	/**
	 *
	 */
	private Integer groupId;
	/**
	 *
	 */
	private String avatarUrl;
	/**
	 *
	 */
	private String language;
	/**
	 *
	 */
	private String openId;
	/**
	 *
	 */
	private String province;
	/**
	 *
	 */
	private String remark;

	/**
	 *
	 */
	private String sexDesc;
	/**
	 * 
	 */
	private Long subscribeTime;
	/**
	 * 
	 */
	private String uniqueId;


	private String nickName;

	private String gender;

	private String telephone;



	@Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                                                        

}
