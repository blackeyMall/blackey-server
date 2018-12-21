package com.blackey.admin.rest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.admin.component.domain.SysMenu;
import com.blackey.admin.component.service.SysMenuService;
import com.blackey.admin.dto.form.SysMenuForm;
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
 * 菜单管理 API REST
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuRest extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysMenuRest.class);

    @Autowired
    private SysMenuService sysMenuService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("admin:sysmenu:list")
    public Result listPage(@RequestBody SysMenuForm sysMenuForm){

        sysMenuForm.setCreatedBy(getUserId());
        sysMenuForm.setTenantId(getTenangtId());
        IPage<SysMenu> page = sysMenuService.queryPage(sysMenuForm,
                new Page<>(sysMenuForm.getCurrent(),sysMenuForm.getSize()));

        return success(page);
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{parentId}")
    public Result info(@PathVariable("parentId") String parentId){

        SysMenu sysMenu = sysMenuService.getById(parentId);

        return success(sysMenu);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody SysMenuForm sysMenuForm){

        SysMenu sysMenu = new SysMenu();
        //Form --> domain
        BeanUtils.copyProperties(sysMenuForm,sysMenu);

        sysMenuService.save(sysMenu);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody SysMenu sysMenu){

        sysMenuService.updateById(sysMenu);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{parentId}")
    public Result delete(@PathVariable("parentId") String parentId){

        sysMenuService.removeById(parentId);

        return success();
    }

}
