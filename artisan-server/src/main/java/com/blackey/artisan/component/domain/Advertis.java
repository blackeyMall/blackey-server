package com.blackey.artisan.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.artisan.global.constants.PicPositionStatus;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author kavenW
 * @date 2018-11-07 09:50:15
 */
@Getter
@Setter
@TableName("advertis")
public class Advertis extends BaseModel<Advertis> implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * 
	 */
	private PicPositionStatus picPosition;
	/**
	 * 
	 */
	private String picUrl;
	/**
	 * 
	 */
	private Integer adsRemark;
	/**
	 * 
	 */
	private String adsOrder;
	/**
	 * 
	 */
	private String redirectUrl;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                            

}
