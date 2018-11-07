package com.blackey.artisan.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.artisan.global.constants.PicTypeStatus;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author kavenW
 * @date 2018-11-07 19:42:29
 */
@Getter
@Setter
@TableName("picture_info")
public class PictureInfo extends BaseModel<PictureInfo> implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * 
	 */
	private String picType;
	/**
	 * 
	 */
	private PicTypeStatus picUrl;
	/**
	 * 
	 */
	private String proDesc;

	private String objectId;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                    

}
