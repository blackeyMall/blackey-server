package com.blackey.artisan.rest;

import com.blackey.common.rest.BaseRest;
import me.chanjar.weixin.common.error.WxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.artisan.component.domain.User;
import com.blackey.artisan.dto.form.UserForm;
import com.blackey.artisan.component.service.UserService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 *  API REST
 *
 * @author kavenW
 * @date 2018-11-04 21:12:23
 */
@RestController
@RequestMapping("/artisan/user")
public class UserRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRest.class);

    @Autowired
    private UserService userService;


    /**
    * 分页列表
    */
    @RequestMapping("/list/page")
    @RequiresPermissions("artisan:user:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = userService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestBody UserForm userForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){

        User user = userService.getById(id);

        return success(user);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody UserForm userForm){

        User user = new User();
        //Form --> domain
        BeanUtils.copyProperties(userForm,user);

        userService.save(user);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody User user){
        userService.updateById(user);
        return success();
    }

    /**
     * 根据主键id删除
     */
    @RequestMapping("/delete/{id}")
    public Result delete(@PathVariable("id") String id){

        userService.removeById(id);

        return success();
    }



    @RequestMapping("/save")
    @PostMapping
    public Result save(HttpServletRequest request, @RequestParam String encryptData, @RequestParam String vi){
        userService.saveWxUserForm(request,encryptData,vi);
        return success();
    }

    @RequestMapping("/login")
    @PostMapping
    public Result login(@ModelAttribute WxUserInfoForm form, HttpServletRequest request){
        try {
            return success(userService.login(request,form));
        } catch (WxErrorException e){
            return failure(e.getMessage());
        }
    }

}
