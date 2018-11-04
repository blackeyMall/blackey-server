package com.blackey.artisan.component.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;

import java.io.Serializable;

/**
 * 
 *
 * @author kavenW
 * @date 2018-11-04 12:10:24
 */
@TableName("order")
public class Order extends BaseModel<Order> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private String orderNo;
	/**
	 * 
	 */
	private String userId;
	/**
	 * 
	 */
	private Integer projectId;

	/**
	 * set：
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * get：
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * set：
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * get：
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * set：
	 */
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	/**
	 * get：
	 */
	public Integer getProjectId() {
		return projectId;
	}

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                    

}
