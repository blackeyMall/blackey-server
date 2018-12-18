package com.blackey.admin.rest;

import com.blackey.admin.component.domain.SysUserRole;
import com.blackey.admin.component.service.SysUserRoleService;
import com.blackey.admin.dto.form.SysUserRoleForm;
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
 * 用户与角色对应关系 API REST
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@RestController
@RequestMapping("/admin/sysuserrole")
public class SysUserRoleRest extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserRoleRest.class);

    @Autowired
    private SysUserRoleService sysUserRoleService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("admin:sysuserrole:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = sysUserRoleService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody SysUserRoleForm sysUserRoleForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{userId}")
    public Result info(@PathVariable("userId") String userId){

        SysUserRole sysUserRole = sysUserRoleService.getById(userId);

        return success(sysUserRole);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody SysUserRoleForm sysUserRoleForm){

        SysUserRole sysUserRole = new SysUserRole();
        //Form --> domain
        BeanUtils.copyProperties(sysUserRoleForm,sysUserRole);

        sysUserRoleService.save(sysUserRole);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody SysUserRole sysUserRole){

        sysUserRoleService.updateById(sysUserRole);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{userId}")
    public Result delete(@PathVariable("userId") String userId){

        sysUserRoleService.removeById(userId);

        return success();
    }

}
