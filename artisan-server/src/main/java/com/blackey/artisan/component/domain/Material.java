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
@TableName("material")
public class Material extends BaseModel<Material> implements Serializable {

    private static final long serialVersionUID = 1L;

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
        return this.getId();
    }
                                            

}
