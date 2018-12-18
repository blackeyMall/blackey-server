package com.blackey.admin.rest;

import com.blackey.admin.component.domain.SysUser;
import com.blackey.admin.component.service.SysUserService;
import com.blackey.admin.dto.form.SysUserForm;
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
 * 系统用户 API REST
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@RestController
@RequestMapping("/admin/sysuser")
public class SysUserRest extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserRest.class);

    @Autowired
    private SysUserService sysUserService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("admin:sysuser:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = sysUserService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody SysUserForm sysUserForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{userName}")
    public Result info(@PathVariable("userName") String userName){

        SysUser sysUser = sysUserService.getById(userName);

        return success(sysUser);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody SysUserForm sysUserForm){

        SysUser sysUser = new SysUser();
        //Form --> domain
        BeanUtils.copyProperties(sysUserForm,sysUser);

        sysUserService.save(sysUser);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody SysUser sysUser){

        sysUserService.updateById(sysUser);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{userName}")
    public Result delete(@PathVariable("userName") String userName){

        sysUserService.removeById(userName);

        return success();
    }

}
