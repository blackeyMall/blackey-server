package com.blackey.admin.rest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.admin.component.domain.SysUser;
import com.blackey.admin.component.service.SysUserService;
import com.blackey.admin.dto.form.PasswordForm;
import com.blackey.admin.dto.form.SysUserForm;
import com.blackey.admin.global.constants.RoleEnum;
import com.blackey.common.result.Result;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统用户 API REST
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserRest extends AbstractController {


    @Autowired
    private SysUserService sysUserService;


    /**
     * 用户分页列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody SysUserForm form){

        Page<SysUser> page = new Page<>(form.getCurrent(),form.getSize());
        if(getUser().getRoleType() != RoleEnum.ROLE_SUPER.getCode()
                && getUser().getRoleType() != RoleEnum.ROLE_ADMIN.getCode()){
            return success(page.setRecords(null));
        }
        form.setCreatedBy(getUserId());
        form.setTenantId(getTenangtId());
        form.setRoleType(getUser().getRoleType());
        List<SysUser> sysUsers = sysUserService.queryPage(form, page);
        return success(page.setRecords(sysUsers));
    }

    /**
     * 获取登录的用户信息
     * @return
     */
    @GetMapping("/info")
    public Result getCurrentUser(){
        return success(getUser());
    }

    /**
     * 查看用户详情信息
     * @param id
     * @return
     */
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){

        SysUser sysUser = sysUserService.getById(id);

        return success(sysUser);
    }

    /**
     * 管理员创建用户
     */
    @PostMapping("/save")
    public Result save(@RequestBody SysUser sysUser){
        sysUser.setTenantId(getTenangtId());
        sysUser.setCreatedBy(getUserId());
        sysUser.setUpdatedBy(getUserId());
        sysUserService.createUser(sysUser);
        return success();
    }

    /**
     * 修改用户信息
     */
    @PostMapping("/update")
    public Result update(@RequestBody SysUser sysUser){
        //全部更新
        sysUser.setUpdatedBy(getUserId());
        sysUserService.updateUser(sysUser);
        return success();
    }

    /**
     * 根据主键id删除
     */
    @PostMapping("/delete")
    public Result delete(@RequestBody String[] ids){

        for(String id : ids){
            SysUser sysUser = sysUserService.getById(id);
            if(sysUser.getRoleType() == RoleEnum.ROLE_SUPER.getCode()){
                return failure("系统管理员不能删除");
            }

            if(id.equals(getUserId())){
                return failure("当前用户不能删除");
            }
        }
        sysUserService.deleteUserBatch(ids);
        return success();
    }

    /**
     * 修改登录用户密码
     * @param form
     * @return
     */
    @PostMapping("/password")
    public Result password(@RequestBody PasswordForm form){

        //sha256加密
        String password = new Sha256Hash(form.getPassword(), getUser().getSalt()).toHex();
        if(!getUser().getPassword().equals(password)){
            return failure("原密码不正确");
        }
        //sha256加密
        String newPassword = new Sha256Hash(form.getNewPassword(), getUser().getSalt()).toHex();
        //更新密码
        sysUserService.updatePassword(getUserId(), password, newPassword);

        return success();
    }

}
