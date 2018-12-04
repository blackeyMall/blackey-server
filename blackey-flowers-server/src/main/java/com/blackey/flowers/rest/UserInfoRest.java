package com.blackey.flowers.rest;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blackey.common.rest.BaseRest;
import com.google.gson.Gson;
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

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 用户信息表 API REST
 *
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
@RestController
@RequestMapping("/flowers/user")
public class UserInfoRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoRest.class);

    @Autowired
    private UserInfoService userInfoService;


    /**
    * 分页列表
    */
    @GetMapping("/list/page")
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
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoForm,userInfo);
        Wrapper wrapper = new QueryWrapper();
        ((QueryWrapper) wrapper).setEntity(userInfo);
        List<UserInfo> list = userInfoService.list(wrapper);
        return success(list);
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

        UserInfo user = userInfoService.findByOpenId(userInfoForm.getOpenId());

        if (user == null){
            user = new UserInfo();
            BeanUtils.copyProperties(userInfoForm,user);
            userInfoService.save(user);
        }else{
            BeanUtils.copyProperties(userInfoForm,user);
            user.setId(userInfoService.findByOpenId(userInfoForm.getOpenId()).getId());
            this.update(user);
        }

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody UserInfo userInfo){

        userInfoService.updateById(userInfo);
        
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

    /**
     * 根据openid查找用户信息
     */
    @GetMapping("/query/{openId}")
    public Result findByOpenId(@PathVariable("openId") String openId){

        UserInfo userInfo = userInfoService.findByOpenId(openId);

        return success(userInfo);
    }

}
