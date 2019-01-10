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
 * @date 2019-01-02 13:47:16
 */
@Getter
@Setter
@TableName("share_relation")
public class ShareRelation extends BaseModel<ShareRelation> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 父ID
     */
	private String parentOpenid;
	/**
	 * 本人id
	 */
	private String openid;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
        

}
