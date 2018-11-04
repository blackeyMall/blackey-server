package com.blackey.artisan.dto.bo;

import java.io.Serializable;
import java.util.Date;

/**
 *  BO
 * 
 * @author kavenW
 * @date 2018-11-04 12:10:24
 */
public class UserBo implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
    private String id;
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
    private String headImgUrl;
	/**
	 * 
	 */
    private String language;
	/**
	 * 
	 */
    private String nickname;
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
    private Integer sex;
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
    private String unionId;
	/**
	 * 
	 */
    private Integer isDeleted;

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
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * get：
	 */
	public String getCity() {
		return city;
	}
	/**
	 * set：
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * get：
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * set：
	 */
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	/**
	 * get：
	 */
	public Integer getGroupId() {
		return groupId;
	}
	/**
	 * set：
	 */
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	/**
	 * get：
	 */
	public String getHeadImgUrl() {
		return headImgUrl;
	}
	/**
	 * set：
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * get：
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * set：
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * get：
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * set：
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	/**
	 * get：
	 */
	public String getOpenId() {
		return openId;
	}
	/**
	 * set：
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * get：
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * set：
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * get：
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * set：
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * get：
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * set：
	 */
	public void setSexDesc(String sexDesc) {
		this.sexDesc = sexDesc;
	}
	/**
	 * get：
	 */
	public String getSexDesc() {
		return sexDesc;
	}
	/**
	 * set：
	 */
	public void setSubscribeTime(Long subscribeTime) {
		this.subscribeTime = subscribeTime;
	}
	/**
	 * get：
	 */
	public Long getSubscribeTime() {
		return subscribeTime;
	}
	/**
	 * set：
	 */
	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}
	/**
	 * get：
	 */
	public String getUnionId() {
		return unionId;
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
}
