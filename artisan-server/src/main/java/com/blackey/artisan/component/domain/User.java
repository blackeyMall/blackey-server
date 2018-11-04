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

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                                                            

}
