package com.blackey.artisan.component.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.artisan.component.domain.Order;
import com.blackey.artisan.dto.bo.OrderInfoBo;
import com.blackey.artisan.dto.bo.SumBo;
import com.blackey.artisan.dto.form.OrderForm;
import com.blackey.mybatis.dao.BaseDAO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 *  OrderMapper
 * 
 * @author kavenW
 * @date 2018-11-04 21:12:24
 */

public interface OrderMapper extends BaseDAO<Order> {


    List<OrderInfoBo> getMainPageOrderList(OrderForm form);

    SumBo getUserOrderCount(String openId);
	
}
