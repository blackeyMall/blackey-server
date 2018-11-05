package com.blackey.invest.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 上传bp文件信息 BO
 * 
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@Getter
@Setter
public class DiagBpFileBo implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
    private Long id;
	/**
	 * 文件名称
	 */
    private String fileName;
	/**
	 * 文件路径
	 */
    private String filePath;
	/**
	 * 项目编号
	 */
    private String projectNo;
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

}
