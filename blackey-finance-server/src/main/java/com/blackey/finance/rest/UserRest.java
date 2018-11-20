package com.blackey.finance.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.finance.component.domain.User;
import com.blackey.finance.dto.form.UserForm;
import com.blackey.finance.component.service.UserService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 用户信息表 API REST
 *
 * @author kaven
 * @date 2018-11-20 23:27:03
 */
@RestController
@RequestMapping("/finance/user")
public class UserRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRest.class);

    @Autowired
    private UserService userService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("finance:user:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = userService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody UserForm userForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){

        User user = userService.getById(id);

        return success(user);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
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

        userService.updateById(user);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable("id") String id){

        userService.removeById(id);

        return success();
    }

}
