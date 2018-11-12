package com.blackey.artisan.component.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.artisan.component.domain.ServiceProcess;
import com.blackey.artisan.dto.bo.ServiceProcessBo;
import com.blackey.mybatis.dao.BaseDAO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 *  ServiceProcessMapper
 * 
 * @author kavenW
 * @date 2018-11-06 23:04:13
 */

public interface ServiceProcessMapper extends BaseDAO<ServiceProcess> {


   List<ServiceProcessBo> queryBoByOrderId(@Param("orderId") String orderId, Page page);


   ServiceProcess queryOneByOrderId(@Param("orderId") String orderId);
}
