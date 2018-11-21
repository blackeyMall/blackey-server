package com.blackey.finance.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 图片表
 *
 * @author kaven
 * @date 2018-11-20 23:27:02
 */
@Getter
@Setter
@TableName("image")
public class Image extends BaseModel<Image> implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * 图片类型
	 */
	private String imageType;
	/**
	 * 对象id
	 */
	private String objectId;
	/**
	 * 图片url
	 */
	private String imageUrl;
	/**
	 * 内容
	 */
	private String content;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                        

}
