package com.blackey.flowers.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.flowers.component.domain.AddressInfo;

import java.util.Map;

/**
 * 收货地址信息表 AddressInfoService
 *
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
public interface AddressInfoService extends BaseService<AddressInfo> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

