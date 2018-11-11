package com.blackey.artisan.component.mapper;

import com.blackey.artisan.component.domain.ServiceInfo;
import com.blackey.artisan.dto.bo.ServiceInfoBo;
import com.blackey.artisan.dto.bo.ServiceProcessBo;
import com.blackey.mybatis.dao.BaseDAO;


/**
 *  ServiceInfoMapper
 * 
 * @author kavenW
 * @date 2018-11-06 13:45:21
 */

public interface ServiceInfoMapper extends BaseDAO<ServiceInfo> {


    ServiceInfoBo queryByOrderId(String orderId);
}
