package com.blackey.bbs.component.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseLongModel;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员等级信息表
 *
 * @author kaven
 * @date 2020-02-16 18:51:35
 */
@Getter
@Setter
@TableName("t_user_grade_info")
public class UserGradeInfo extends BaseLongModel<UserGradeInfo> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 会员等级名称
	 */
	private String gradeName;
	/**
	 * 会员等级icon
	 */
	private String gradeIcon;
	/**
	 * 所需积分
	 */
	private Long needPoint;

    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
            

}
