package com.blackey.admin.component.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 系统配置信息表
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Getter
@Setter
@TableName("sys_config")
public class SysConfig extends BaseModel<SysConfig> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * key
	 */
	private String paramKey;
	/**
	 * value
	 */
	private String paramValue;
	/**
	 * 状态   0：隐藏   1：显示
	 */
	private Integer status;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 租户ID
	 */
	private String tenantId;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                    

}
