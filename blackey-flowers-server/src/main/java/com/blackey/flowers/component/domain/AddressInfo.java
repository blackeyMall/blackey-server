package com.blackey.flowers.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 收货地址信息表
 *
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
@Getter
@Setter
@TableName("t_address_info")
public class AddressInfo extends BaseModel<AddressInfo> implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * 地址编号
	 */
	private String addressNo;
	/**
	 * 地址详情
	 */
	private String addressDetail;
	/**
	 * 用户编号
	 */
	private String userNo;


    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                    

}
