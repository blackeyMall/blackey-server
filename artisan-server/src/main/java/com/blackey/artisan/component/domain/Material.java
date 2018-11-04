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
@TableName("material")
public class Material extends BaseModel<Material> implements Serializable {

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
	private String mName;
	/**
	 * 
	 */
	private String mPicUrl;
	/**
	 * 
	 */
	private Integer mDesc;
	/**
	 * 
	 */
	private Integer mNum;
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
	public void setMName(String mName) {
		this.mName = mName;
	}
	/**
	 * get：
	 */
	public String getMName() {
		return mName;
	}
	/**
	 * set：
	 */
	public void setMPicUrl(String mPicUrl) {
		this.mPicUrl = mPicUrl;
	}
	/**
	 * get：
	 */
	public String getMPicUrl() {
		return mPicUrl;
	}
	/**
	 * set：
	 */
	public void setMDesc(Integer mDesc) {
		this.mDesc = mDesc;
	}
	/**
	 * get：
	 */
	public Integer getMDesc() {
		return mDesc;
	}
	/**
	 * set：
	 */
	public void setMNum(Integer mNum) {
		this.mNum = mNum;
	}
	/**
	 * get：
	 */
	public Integer getMNum() {
		return mNum;
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
