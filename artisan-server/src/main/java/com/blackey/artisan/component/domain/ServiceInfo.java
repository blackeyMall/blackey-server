package com.blackey.artisan.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author kavenW
 * @date 2018-11-06 13:45:21
 */
@Getter
@Setter
@TableName("service_info")
public class ServiceInfo extends BaseModel<ServiceInfo> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private String serviceTime;
	/**
	 * 
	 */
	private String address;
	/**
	 * 
	 */
	private String remark;
	/**
	 * 
	 */
	private String telephone;
	/**
	 * 
	 */
	private String name;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                            

}
