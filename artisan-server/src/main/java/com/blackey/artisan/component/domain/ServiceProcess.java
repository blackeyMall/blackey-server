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
 * @date 2018-11-06 23:04:13
 */
@Getter
@Setter
@TableName("service_process")
public class ServiceProcess extends BaseModel<ServiceProcess> implements Serializable {

    private static final long serialVersionUID = 1L;


	private String content;
	/**
	 * 
	 */
	private String orderId;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                    

}
