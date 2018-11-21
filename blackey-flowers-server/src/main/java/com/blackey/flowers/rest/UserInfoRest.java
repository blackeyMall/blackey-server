package com.blackey.flowers.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.flowers.component.domain.UserInfo;
import com.blackey.flowers.dto.form.UserInfoForm;
import com.blackey.flowers.component.service.UserInfoService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 用户信息表 API REST
 *
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
@RestController
@RequestMapping("/flowers/userinfo")
public class UserInfoRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoRest.class);

    @Autowired
    private UserInfoService userInfoService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("flowers:userinfo:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = userInfoService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody UserInfoForm userInfoForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){

        UserInfo userInfo = userInfoService.getById(id);

        return success(userInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody UserInfoForm userInfoForm){

        UserInfo userInfo = new UserInfo();
        //Form --> domain
        BeanUtils.copyProperties(userInfoForm,userInfo);

        userInfoService.save(userInfo);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody UserInfo userInfo){

        userInfoService.updateById(userInfo);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable("id") String id){

        userInfoService.removeById(id);

        return success();
    }

}
