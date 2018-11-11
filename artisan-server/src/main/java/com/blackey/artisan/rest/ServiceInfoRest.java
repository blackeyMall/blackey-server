package com.blackey.artisan.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.artisan.component.domain.ServiceInfo;
import com.blackey.artisan.dto.form.ServiceInfoForm;
import com.blackey.artisan.component.service.ServiceInfoService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 *  API REST
 *
 * @author kavenW
 * @date 2018-11-06 13:45:21
 */
@RestController
@RequestMapping("/artisan/serviceinfo")
public class ServiceInfoRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceInfoRest.class);

    @Autowired
    private ServiceInfoService serviceInfoService;


    /**
    * 分页列表
    */
    @RequestMapping("/list/page")
    @RequiresPermissions("artisan:serviceinfo:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = serviceInfoService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestBody ServiceInfoForm serviceInfoForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){

        ServiceInfo serviceInfo = serviceInfoService.getById(id);

        return success(serviceInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody ServiceInfoForm serviceInfoForm){

        ServiceInfo serviceInfo = new ServiceInfo();
        //Form --> domain
        BeanUtils.copyProperties(serviceInfoForm,serviceInfo);

        serviceInfoService.save(serviceInfo);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody ServiceInfo serviceInfo){

        serviceInfoService.updateById(serviceInfo);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @RequestMapping("/delete/{id}")
    public Result delete(@PathVariable("id") String id){

        serviceInfoService.removeById(id);

        return success();
    }

    /**
     * 根据主键id删除
     */
    @RequestMapping("/order")
    public Result findByOrder(@RequestParam String orderId){

        return success(serviceInfoService.queryByOrderId(orderId));
    }

}
