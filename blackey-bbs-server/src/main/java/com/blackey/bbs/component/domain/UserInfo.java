package com.blackey.bbs.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseLongModel;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 会员用户信息表
 *
 * @author kaven
 * @date 2020-02-16 18:51:35
 */
@Getter
@Setter
@TableName("t_user_info")
public class UserInfo extends BaseLongModel<UserInfo> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 用户名称
	 */
	private String userName;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 用户状态
	 */
	private Integer status;
	/**
	 * 头像路径
	 */
	private String avatarPath;
	/**
	 * 会员等级id
	 */
	private Long gradeId;
	/**
	 * 会员等级名称
	 */
	private String gradeName;
	/**
	 * 会员积分
	 */
	private Long point;
	/**
	 * 会员金额
	 */
	private BigDecimal amount;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                        

}
