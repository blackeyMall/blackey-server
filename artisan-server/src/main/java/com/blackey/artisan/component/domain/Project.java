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
@TableName("project")
public class Project extends BaseModel<Project> implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                    

}
