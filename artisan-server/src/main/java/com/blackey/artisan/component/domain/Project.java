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
 * @date 2018-11-04 21:12:24
 */
@Getter
@Setter
@TableName("project")
public class Project extends BaseModel<Project> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String picUrl;
	/**
	 * 
	 */
	private String proDesc;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                    

}
