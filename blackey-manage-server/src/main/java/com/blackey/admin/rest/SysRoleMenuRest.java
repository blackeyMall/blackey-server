package com.blackey.admin.rest;

import com.blackey.admin.component.domain.SysRoleMenu;
import com.blackey.admin.component.service.SysRoleMenuService;
import com.blackey.admin.dto.form.SysRoleMenuForm;
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
 * 角色与菜单对应关系 API REST
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@RestController
@RequestMapping("/sy/sysrolemenu")
public class SysRoleMenuRest extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysRoleMenuRest.class);

    @Autowired
    private SysRoleMenuService sysRoleMenuService;


    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody SysRoleMenuForm sysRoleMenuForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{roleId}")
    public Result info(@PathVariable("roleId") String roleId){

        SysRoleMenu sysRoleMenu = sysRoleMenuService.getById(roleId);

        return success(sysRoleMenu);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody SysRoleMenuForm sysRoleMenuForm){

        SysRoleMenu sysRoleMenu = new SysRoleMenu();
        //Form --> domain
        BeanUtils.copyProperties(sysRoleMenuForm,sysRoleMenu);

        sysRoleMenuService.save(sysRoleMenu);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody SysRoleMenu sysRoleMenu){

        sysRoleMenuService.updateById(sysRoleMenu);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{roleId}")
    public Result delete(@PathVariable("roleId") String roleId){

        sysRoleMenuService.removeById(roleId);

        return success();
    }

}
