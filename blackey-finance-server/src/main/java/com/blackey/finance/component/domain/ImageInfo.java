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
 * @date 2018-12-07 09:48:53
 */
@Getter
@Setter
@TableName("t_image_info")
public class ImageInfo extends BaseModel<ImageInfo> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 图片类型
	 */
	@TableId
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
        return this.getImageType();
    }
                

}
