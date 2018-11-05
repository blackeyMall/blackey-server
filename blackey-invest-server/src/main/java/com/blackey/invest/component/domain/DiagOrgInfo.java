package com.blackey.invest.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业诊断机构信息
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@Getter
@Setter
@TableName("diag_org_info")
public class DiagOrgInfo extends BaseModel<DiagOrgInfo> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer id;
	/**
	 * 机构编号
	 */
	private String orgNo;
	/**
	 * 机构名称
	 */
	private String orgName;
	/**
	 * 机构描述
	 */
	private String orgDesc;
	/**
	 * 上级部门ID，一级部门为0
	 */
	private Long parentId;
	/**
	 * 排序
	 */
	private Integer orderNum;
	/**
	 * 逻辑删除
	 */
	private Integer isDeleted;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 更新人
	 */
	private String updateBy;
	/**
	 * 更新时间
	 */
	private Date updateDate;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                            

}
