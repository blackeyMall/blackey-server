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
 * @author kaven
 * @date 2019-01-02 09:47:38
 */
@Getter
@Setter
@TableName("comment")
public class Comment extends BaseModel<Comment> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer comment;
	/**
	 * 
	 */
	private Integer serviceStatus;
	/**
	 * 
	 */
	private Integer responseSpeed;

	private String serviceId;

    @Override
    protected Serializable pkVal() {
        return this.getComment();
    }
            

}
