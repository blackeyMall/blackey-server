package com.blackey.artisan.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.artisan.global.constants.FeedBackStatus;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author kavenW
 * @date 2018-11-05 11:01:32
 */
@Getter
@Setter
@TableName("feedback")
public class Feedback extends BaseModel<Feedback> implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * 
	 */
	private String content;
	/**
	 * 
	 */
	private String userId;
	/**
	 * 
	 */
	private String projectId;
	/**
	 * 
	 */
	private FeedBackStatus feedBackType;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                        

}
