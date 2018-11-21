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
	 * 主键
	 */
	@TableId
	private Long id;
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
	/**
	 * 删除标志
	 */
	private Integer isDeleted;
	/**
	 * 创建人
	 */
	private String createdBy;
	/**
	 * 创建时间
	 */
	private Date createdDate;
	/**
	 * 修改人
	 */
	private String updatedBy;
	/**
	 * 修改时间
	 */
	private Date updatedDate;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                    

}
