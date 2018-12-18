package com.blackey.admin.rest;

import com.blackey.admin.component.domain.SysUserToken;
import com.blackey.admin.component.service.SysUserTokenService;
import com.blackey.admin.dto.form.SysUserTokenForm;
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
 * 系统用户Token API REST
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@RestController
@RequestMapping("/admin/sysusertoken")
public class SysUserTokenRest extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserTokenRest.class);

    @Autowired
    private SysUserTokenService sysUserTokenService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("admin:sysusertoken:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = sysUserTokenService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody SysUserTokenForm sysUserTokenForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{userId}")
    public Result info(@PathVariable("userId") String userId){

        SysUserToken sysUserToken = sysUserTokenService.getById(userId);

        return success(sysUserToken);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody SysUserTokenForm sysUserTokenForm){

        SysUserToken sysUserToken = new SysUserToken();
        //Form --> domain
        BeanUtils.copyProperties(sysUserTokenForm,sysUserToken);

        sysUserTokenService.save(sysUserToken);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody SysUserToken sysUserToken){

        sysUserTokenService.updateById(sysUserToken);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{userId}")
    public Result delete(@PathVariable("userId") String userId){

        sysUserTokenService.removeById(userId);

        return success();
    }

}
