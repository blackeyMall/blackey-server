package com.blackey.admin.rest;

import com.blackey.admin.component.domain.SysRole;
import com.blackey.admin.component.service.SysRoleService;
import com.blackey.admin.dto.form.SysRoleForm;
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
 * 角色 API REST
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@RestController
@RequestMapping("/admin/sysrole")
public class SysRoleRest extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysRoleRest.class);

    @Autowired
    private SysRoleService sysRoleService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("admin:sysrole:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = sysRoleService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody SysRoleForm sysRoleForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{roleName}")
    public Result info(@PathVariable("roleName") String roleName){

        SysRole sysRole = sysRoleService.getById(roleName);

        return success(sysRole);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody SysRoleForm sysRoleForm){

        SysRole sysRole = new SysRole();
        //Form --> domain
        BeanUtils.copyProperties(sysRoleForm,sysRole);

        sysRoleService.save(sysRole);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody SysRole sysRole){

        sysRoleService.updateById(sysRole);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{roleName}")
    public Result delete(@PathVariable("roleName") String roleName){

        sysRoleService.removeById(roleName);

        return success();
    }

}
