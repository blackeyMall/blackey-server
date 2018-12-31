package com.blackey.admin.rest;

import com.blackey.admin.component.domain.SysTenantMenu;
import com.blackey.admin.component.service.SysTenantMenuService;
import com.blackey.admin.dto.form.SysTenantMenuForm;
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
 *  API REST
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@RestController
@RequestMapping("/admin/systenantmenu")
public class SysTenantMenuRest extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysTenantMenuRest.class);

    @Autowired
    private SysTenantMenuService sysTenantMenuService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("admin:systenantmenu:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = sysTenantMenuService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody SysTenantMenuForm sysTenantMenuForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{tenantId}")
    public Result info(@PathVariable("tenantId") Long tenantId){

        SysTenantMenu sysTenantMenu = sysTenantMenuService.getById(tenantId);

        return success(sysTenantMenu);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody SysTenantMenuForm sysTenantMenuForm){

        SysTenantMenu sysTenantMenu = new SysTenantMenu();
        //Form --> domain
        BeanUtils.copyProperties(sysTenantMenuForm,sysTenantMenu);

        sysTenantMenuService.save(sysTenantMenu);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody SysTenantMenu sysTenantMenu){

        sysTenantMenuService.updateById(sysTenantMenu);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{tenantId}")
    public Result delete(@PathVariable("tenantId") Long tenantId){

        sysTenantMenuService.removeById(tenantId);

        return success();
    }

}
