package com.blackey.admin.rest;

import com.blackey.admin.component.domain.SysConfig;
import com.blackey.admin.component.service.SysConfigService;
import com.blackey.admin.dto.form.SysConfigForm;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 系统配置信息表 API REST
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@RestController
@RequestMapping("/admin/sysconfig")
public class SysConfigRest extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysConfigRest.class);

    @Autowired
    private SysConfigService sysConfigService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("admin:sysconfig:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = sysConfigService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody SysConfigForm sysConfigForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{paramKey}")
    public Result info(@PathVariable("paramKey") String paramKey){

        SysConfig sysConfig = sysConfigService.getById(paramKey);

        return success(sysConfig);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody SysConfigForm sysConfigForm){

        SysConfig sysConfig = new SysConfig();
        //Form --> domain
        BeanUtils.copyProperties(sysConfigForm,sysConfig);

        sysConfigService.save(sysConfig);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody SysConfig sysConfig){

        sysConfigService.updateById(sysConfig);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{paramKey}")
    public Result delete(@PathVariable("paramKey") String paramKey){

        sysConfigService.removeById(paramKey);

        return success();
    }

}
