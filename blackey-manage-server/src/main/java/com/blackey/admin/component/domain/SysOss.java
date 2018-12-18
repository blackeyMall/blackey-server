package com.blackey.admin.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件上传
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Getter
@Setter
@TableName("sys_oss")
public class SysOss implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId
	private String id;
	/**
	 * URL地址
	 */
	private String url;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 租户ID
	 */
	private String tenantId;

    protected Serializable pkVal() {
        return this.getId();
    }
            

}
