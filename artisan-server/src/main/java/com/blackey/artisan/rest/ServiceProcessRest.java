package com.blackey.artisan.rest;

import cn.hutool.core.bean.BeanUtil;
import com.blackey.artisan.component.domain.PictureInfo;
import com.blackey.artisan.component.service.PictureInfoService;
import com.blackey.artisan.global.constants.PicTypeStatus;
import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.artisan.component.domain.ServiceProcess;
import com.blackey.artisan.dto.form.ServiceProcessForm;
import com.blackey.artisan.component.service.ServiceProcessService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * API REST
 *
 * @author kavenW
 * @date 2018-11-06 23:04:13
 */
@RestController
@RequestMapping("/artisan/serviceprocess")
public class ServiceProcessRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceProcessRest.class);

    @Autowired
    private ServiceProcessService serviceProcessService;

    @Resource
    PictureInfoService pictureInfoService;


    /**
     * 分页列表
     */
    @RequestMapping("/list/page")
    @RequiresPermissions("artisan:serviceprocess:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = serviceProcessService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestBody ServiceProcessForm serviceProcessForm) {
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") String id) {

        ServiceProcess serviceProcess = serviceProcessService.getById(id);

        return success(serviceProcess);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody ServiceProcessForm serviceProcessForm) {

        ServiceProcess serviceProcess = new ServiceProcess();
        //Form --> domain
        BeanUtils.copyProperties(serviceProcessForm, serviceProcess);
        serviceProcessService.save(serviceProcess);
        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody ServiceProcess serviceProcess) {

        serviceProcessService.updateById(serviceProcess);//全部更新

        return success();
    }

    /**
     * 根据主键id删除
     */
    @RequestMapping("/delete/{id}")
    public Result delete(@PathVariable("id") String id) {

        serviceProcessService.removeById(id);

        return success();
    }

    /**
     * 查询进度数据
     * @param form
     * @return
     */
    @PostMapping("/query/process")
    public Result queryProcess(@RequestBody ServiceProcessForm form) {

        return success(serviceProcessService.queryProcess(form));

    }

    /**
     * 保存进度数据
     * @param form
     * @return
     */
    @PostMapping("/save/process")
    public Result saveProcess(@RequestBody ServiceProcessForm form){
        ServiceProcess serviceProcess = new ServiceProcess();
        //Form --> domain
        BeanUtils.copyProperties(form, serviceProcess);
        serviceProcessService.save(serviceProcess);


        for (String picUrl:
                form.getPicUrls() ) {
            PictureInfo pictureInfo = new PictureInfo();
            pictureInfo.setObjectId(serviceProcess.getId());
            pictureInfo.setPicType(PicTypeStatus.PROCESS);
            pictureInfo.setPicUrl(picUrl);
            pictureInfoService.save(pictureInfo);
        }

        return success();
    }
}
