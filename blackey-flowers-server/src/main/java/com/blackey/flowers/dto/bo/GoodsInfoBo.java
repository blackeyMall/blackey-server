package com.blackey.flowers.dto.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品表 BO
 * 
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
@Getter
@Setter
public class GoodsInfoBo implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
    private Long id;
	/**
	 * 商品编号
	 */
    private String goodsNo;
	/**
	 * 商品名称
	 */
    private String goodsName;
	/**
	 * 删除标志
	 */
    private Integer isDeleted;
	/**
	 * 创建人
	 */
    private String createdBy;
	/**
	 * 创建时间
	 */
    private Date createdDate;
	/**
	 * 修改人
	 */
    private String updatedBy;
	/**
	 * 修改时间
	 */
    private Date updatedDate;

}
