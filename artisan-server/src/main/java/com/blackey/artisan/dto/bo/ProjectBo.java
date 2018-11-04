package com.blackey.artisan.dto.bo;

import java.io.Serializable;
import java.util.Date;

/**
 *  BO
 * 
 * @author kavenW
 * @date 2018-11-04 12:10:24
 */
public class ProjectBo implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
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
    private String pName;
	/**
	 * 
	 */
    private String pPicUrl;
	/**
	 * 
	 */
    private Integer pDesc;

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
	public void setPName(String pName) {
		this.pName = pName;
	}
	/**
	 * get：
	 */
	public String getPName() {
		return pName;
	}
	/**
	 * set：
	 */
	public void setPPicUrl(String pPicUrl) {
		this.pPicUrl = pPicUrl;
	}
	/**
	 * get：
	 */
	public String getPPicUrl() {
		return pPicUrl;
	}
	/**
	 * set：
	 */
	public void setPDesc(Integer pDesc) {
		this.pDesc = pDesc;
	}
	/**
	 * get：
	 */
	public Integer getPDesc() {
		return pDesc;
	}
}
