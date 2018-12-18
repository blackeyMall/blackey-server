package com.blackey.admin.rest;

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
@RequestMapping("/admin/sysmenu")
public class SysMenuRest extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysMenuRest.class);

    @Autowired
    private SysMenuService sysMenuService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("admin:sysmenu:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = sysMenuService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody SysMenuForm sysMenuForm){
        //TODO
        return success();
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
