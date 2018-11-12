package com.blackey.artisan.component.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blackey.artisan.component.domain.Order;
import com.blackey.artisan.component.service.OrderService;
import com.blackey.artisan.component.service.PictureInfoService;
import com.blackey.artisan.dto.bo.ServiceProcessBo;
import com.blackey.artisan.dto.form.ServiceProcessForm;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.artisan.component.mapper.ServiceProcessMapper;
import com.blackey.artisan.component.domain.ServiceProcess;
import com.blackey.artisan.component.service.ServiceProcessService;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *  ServiceProcessServiceImpl
 *
 * @author kavenW
 * @date 2018-11-06 23:04:13
 */
@Service
public class ServiceProcessServiceImpl extends BaseServiceImpl<ServiceProcessMapper, ServiceProcess> implements ServiceProcessService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceProcessServiceImpl.class);

    @Resource
    private PictureInfoService pictureInfoService;

    @Resource
    private ServiceProcessMapper serviceProcessMapper;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ServiceProcess> page = (Page<ServiceProcess>) this.page(
                new Query<ServiceProcess>(params).getPage(),
                new QueryWrapper<ServiceProcess>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryProcess(ServiceProcessForm form) {
        String orderId = form.getOrderId();

        Page<ServiceProcessBo> serviceProcessBos = new Page<>();
        serviceProcessBos.setRecords(serviceProcessMapper.queryBoByOrderId(orderId,new Page(form.getCurrent(),form.getSize())));
        for (ServiceProcessBo serviceProcessBo:serviceProcessBos.getRecords()
             ) {
            String objectId =serviceProcessBo.getId();
                    List<String> list = pictureInfoService.queryPicList(objectId);
            serviceProcessBo.setPics(list);
        }
        return new PageUtils(serviceProcessBos);
    }


    @Override
    public ServiceProcess queryOneByOrderId(String orderId) {
        return serviceProcessMapper.queryOneByOrderId(orderId);
    }
}
