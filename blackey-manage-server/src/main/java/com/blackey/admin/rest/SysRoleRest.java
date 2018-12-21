package com.blackey.admin.rest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.admin.component.domain.SysRole;
import com.blackey.admin.component.domain.SysUser;
import com.blackey.admin.component.service.SysRoleMenuService;
import com.blackey.admin.component.service.SysRoleService;
import com.blackey.admin.component.service.SysUserService;
import com.blackey.admin.dto.form.SysRoleForm;
import com.blackey.admin.global.constants.RoleEnum;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 角色 API REST
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleRest extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysRoleRest.class);

    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;
    @Autowired
    SysUserService sysUserService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("admin:sysrole:list")
    public Result listPage(@RequestBody SysRoleForm sysRoleForm){

        IPage<SysRole> page = new Page<>(sysRoleForm.getCurrent(),sysRoleForm.getSize());

        sysRoleForm.setCreatedBy(getUserId());
        sysRoleForm.setTenantId(getTenangtId());
        sysRoleForm.setRoleType(getUser().getRoleType());

        return success(sysRoleService.queryPage(sysRoleForm,page));
    }

    /**
     * 查看详情信息
     */
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){

        SysRole sysRole = sysRoleService.getById(id);
        //角色对应的菜单
        List<String> menuIds = sysRoleMenuService.queryMenuIdListByRoleId(sysRole.getId());
        sysRole.setMenuIdList(menuIds);

        return success(sysRole);
    }

    /**
     * 创建角色信息
     */
    @PostMapping("/save")
    public Result save(@RequestBody SysRole sysRole){

        sysRole.setTenantId(getTenangtId());
        sysRole.setCreatedBy(getUserId());
        sysRole.setUpdatedBy(getUserId());
        sysRoleService.saveRole(sysRole);

        return success();
    }

    /**
     * 修改更新角色
     */
    @PostMapping("/update")
    public Result update(@RequestBody SysRole sysRole){
        sysRole.setTenantId(getTenangtId());
        sysRole.setUpdatedBy(getUserId());
        sysRoleService.updateRole(sysRole);
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @PostMapping("/delete")
    public Result delete(@RequestBody String[] ids){

        sysRoleService.deleteBatch(ids);

        return success();
    }

}
