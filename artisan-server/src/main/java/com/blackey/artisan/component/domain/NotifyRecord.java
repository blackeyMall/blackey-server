package com.blackey.artisan.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.artisan.global.constants.NotifyStatus;
import com.blackey.artisan.global.constants.NotifyType;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author kaven
 * @date 2019-01-02 13:47:16
 */
@Getter
@Setter
@TableName("notify_record")
public class NotifyRecord extends BaseModel<NotifyRecord> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String notifyContent;
	/**
	 * 
	 */
	private String notifyUserOpenid;
	/**
	 * 
	 */
	private String notifyUserName;

	private String objectId;
	/**
	 * 
	 */
	private NotifyType notifyType;
	/**
	 * 
	 */
	private NotifyStatus notifyStatus;

    @Override
    protected Serializable pkVal() {
        return this.getNotifyContent();
    }


}
