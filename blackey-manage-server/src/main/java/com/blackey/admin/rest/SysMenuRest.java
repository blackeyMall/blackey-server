package com.blackey.admin.rest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.admin.component.domain.SysMenu;
import com.blackey.admin.component.domain.SysUser;
import com.blackey.admin.component.service.ShiroService;
import com.blackey.admin.component.service.SysMenuService;
import com.blackey.admin.dto.NavVO;
import com.blackey.admin.dto.form.SysMenuForm;
import com.blackey.admin.global.constants.RoleEnum;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;
import com.google.common.collect.Lists;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @Autowired
    ShiroService shiroService;

    /**
     * 导航菜单
     */
    @GetMapping("/nav")
    public Result nav(){
        NavVO navVO = new NavVO();
        List<SysMenu> menuList = sysMenuService.getUserMenuList(getUserId());
        Set<String> permissions = shiroService.getUserPermissions(getUserId());
        navVO.setMenuList(menuList);
        navVO.setPermissions(permissions);
        return success(navVO);
    }

    /**
     * 所有菜单列表
     * 当前用户所属租户的所有菜单
     */
    @GetMapping("/list")
    @RequiresPermissions("sys:menu:list")
    public Result list(){

        List<SysMenu> menuList = Lists.newArrayList();
        SysUser sysUser = getUser();
        if(RoleEnum.ROLE_SUPER.getCode() == sysUser.getRoleType()){
            menuList = sysMenuService.list(null);
        }else {
            sysMenuService.getUserMenuList(getUserId());
        }


        for(SysMenu sysMenuEntity : menuList){
            SysMenu parentMenuEntity = sysMenuService.getById(sysMenuEntity.getParentId());
            if(parentMenuEntity != null){
                sysMenuEntity.setParentName(parentMenuEntity.getName());
            }
        }

        return success(menuList);
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
