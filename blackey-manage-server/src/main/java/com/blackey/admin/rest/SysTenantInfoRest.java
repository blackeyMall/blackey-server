package com.blackey.admin.rest;

import com.blackey.admin.component.domain.SysTenantInfo;
import com.blackey.admin.component.service.SysTenantInfoService;
import com.blackey.admin.dto.form.SysTenantInfoForm;
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
 * 租户信息 API REST
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@RestController
@RequestMapping("/admin/systenantinfo")
public class SysTenantInfoRest extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysTenantInfoRest.class);

    @Autowired
    private SysTenantInfoService sysTenantInfoService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("admin:systenantinfo:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = sysTenantInfoService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody SysTenantInfoForm sysTenantInfoForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{telephone}")
    public Result info(@PathVariable("telephone") String telephone){

        SysTenantInfo sysTenantInfo = sysTenantInfoService.getById(telephone);

        return success(sysTenantInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody SysTenantInfoForm sysTenantInfoForm){

        SysTenantInfo sysTenantInfo = new SysTenantInfo();
        //Form --> domain
        BeanUtils.copyProperties(sysTenantInfoForm,sysTenantInfo);

        sysTenantInfoService.save(sysTenantInfo);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody SysTenantInfo sysTenantInfo){

        sysTenantInfoService.updateById(sysTenantInfo);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{telephone}")
    public Result delete(@PathVariable("telephone") String telephone){

        sysTenantInfoService.removeById(telephone);

        return success();
    }

}
