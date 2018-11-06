package com.blackey.artisan.component.mapper;

import com.blackey.artisan.component.domain.Order;
import com.blackey.artisan.dto.bo.OrderInfoBo;
import com.blackey.artisan.dto.form.OrderForm;
import com.blackey.mybatis.dao.BaseDAO;

import java.util.List;


/**
 *  OrderMapper
 * 
 * @author kavenW
 * @date 2018-11-04 21:12:24
 */

public interface OrderMapper extends BaseDAO<Order> {


    List<OrderInfoBo> getMainPageOrderList(OrderForm form);
	
}
