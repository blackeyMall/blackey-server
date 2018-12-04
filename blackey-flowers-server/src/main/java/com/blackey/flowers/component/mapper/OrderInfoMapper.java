package com.blackey.flowers.component.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.flowers.component.domain.OrderInfo;
import com.blackey.flowers.dto.bo.OrderInfoBo;
import com.blackey.flowers.dto.form.OrderInfoForm;
import com.blackey.mybatis.dao.BaseDAO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 订单信息表 OrderInfoMapper
 * 
 * @author kaven
 * @date 2018-11-20 23:49:38
 */

public interface OrderInfoMapper extends BaseDAO<OrderInfo> {

    @Select("<script>select * from t_user_info u ,t_order_info o " +
            "where u.id = o.user_no " +
            "<if test=\"form.openId != '' and form.openId != null\">" +
            " and u.open_id = #{form.openId}\n" +
            "</if>" +
            "<if test=\"form.tradeStatus != '' and form.tradeStatus != null\">\n" +
            " and o.trade_status = #{form.tradeStatus}\n" +
            "</if>" +
            " order by o.created_date desc </script>")
    List<OrderInfoBo> getOrderlistPage(@Param("form") OrderInfoForm orderInfoForm, Page<OrderInfoBo> page);
}
