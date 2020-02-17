package com.blackey.bbs.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 会员登录信息表
 *
 * @author kaven
 * @date 2020-02-16 18:51:35
 */
@Getter
@Setter
@TableName("t_account_info")
public class AccountInfo extends Model<AccountInfo> implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId
	private Long id;
	/**
	 * 登录账号
	 */
	private String account;
	/**
	 * 账号类型
	 */
	private String accountType;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 盐值
	 */
	private String salt;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                    

}
