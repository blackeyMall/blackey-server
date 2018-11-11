package com.blackey.artisan.component.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.artisan.dto.bo.ServiceProcessBo;
import com.blackey.artisan.dto.form.ServiceProcessForm;
import com.blackey.common.result.Result;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.artisan.component.domain.ServiceProcess;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 *  ServiceProcessService
 *
 * @author kavenW
 * @date 2018-11-06 23:04:13
 */
public interface ServiceProcessService extends BaseService<ServiceProcess> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryProcess(ServiceProcessForm form) ;


}

