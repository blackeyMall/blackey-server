package com.blackey.artisan.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;

import java.io.Serializable;
import java.util.Date;

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
	@TableId
	private String id;
	/**
	 * 
	 */
	private Integer isDeleted;
	/**
	 * 
	 */
	private String createdBy;
	/**
	 * 
	 */
	private Date createdDate;
	/**
	 * 
	 */
	private String updateBy;
	/**
	 * 
	 */
	private Date updatedDate;
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
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * get：
	 */
	public String getId() {
		return id;
	}
	/**
	 * set：
	 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	/**
	 * get：
	 */
	public Integer getIsDeleted() {
		return isDeleted;
	}
	/**
	 * set：
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * get：
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * set：
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * get：
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * set：
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	/**
	 * get：
	 */
	public String getUpdateBy() {
		return updateBy;
	}
	/**
	 * set：
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	/**
	 * get：
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}
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
        return this.id;
    }
                                    

}
