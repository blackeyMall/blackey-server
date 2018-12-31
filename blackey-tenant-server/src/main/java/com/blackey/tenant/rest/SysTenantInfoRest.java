package com.blackey.tenant.rest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.tenant.component.domain.SysMenuEntity;
import com.blackey.tenant.component.service.SysMenuService;
import com.blackey.tenant.component.service.SysTenantMenuService;
import com.blackey.tenant.dto.bo.SysTenantInfoBo;
import com.blackey.tenant.global.constants.RoleEnum;
import com.blackey.common.rest.BaseRest;
import com.blackey.common.result.ResultCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.tenant.component.domain.SysTenantInfo;
import com.blackey.tenant.dto.form.SysTenantInfoForm;
import com.blackey.tenant.component.service.SysTenantInfoService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 租户信息 API REST
 *
 * @author kaven
 * @date 2018-12-12 11:23:05
 */
@RestController
@RequestMapping("/sys/tenant")
public class SysTenantInfoRest extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysTenantInfoRest.class);

    @Autowired
    private SysTenantInfoService sysTenantInfoService;

    @Autowired
    SysTenantMenuService sysTenantMenuService;

    /**
    * 分页列表
    */
    @PostMapping("/list/page")
   // @RequiresPermissions("sys:tenant:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = sysTenantInfoService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    @RequiresPermissions("sys:tenant:list")
    public Result list(@RequestBody SysTenantInfoForm form){
        Page<SysTenantInfo> page = new Page<>(form.getCurrent(),form.getSize());
        IPage<SysTenantInfo> tenantInfoIPage = sysTenantInfoService.listPage(form, page);
        return success(tenantInfoIPage);
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("sys:tenant:info")
    public Result info(@PathVariable("id") Long id){

        SysTenantInfo sysTenantInfo = sysTenantInfoService.getById(id);
        List<Long> menuIds = sysTenantMenuService.queryMenuIdByTenantId(id);
        sysTenantInfo.setMenuIdList(menuIds);

        return success(sysTenantInfo);
    }

    /**
     * 创建租户信息
     */
    @PostMapping("/save")
    @RequiresPermissions("sys:tenant:save")
    public Result save(@RequestBody SysTenantInfo sysTenantInfo){
        if(RoleEnum.ROLE_SUPER.getCode() != getUser().getRoleType()){
            return failure("用户权限不足");
        }
        sysTenantInfoService.saveTenant(sysTenantInfo);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("sys:tenant:update")
    public Result update(@RequestBody SysTenantInfo sysTenantInfo){
        if(RoleEnum.ROLE_SUPER.getCode() != getUser().getRoleType()){
            return failure("用户权限不足");
        }
        sysTenantInfoService.updateTenant(sysTenantInfo);
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{id}")
    @RequiresPermissions("sys:tenant:delete")
    public Result delete(@PathVariable("id") String id){


        if(RoleEnum.ROLE_SUPER.getCode() != getUser().getRoleType()){
            return failure("用户权限不足");
        }
        sysTenantInfoService.deleteTenant(id);

        return success();
    }

}
