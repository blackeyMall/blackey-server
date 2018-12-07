package com.blackey.finance.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.finance.component.domain.UserRequireLike;
import com.blackey.finance.dto.form.UserRequireLikeForm;
import com.blackey.finance.component.service.UserRequireLikeService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 用户需求点赞表 API REST
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@RestController
@RequestMapping("/finance/userrequirelike")
public class UserRequireLikeRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRequireLikeRest.class);

    @Autowired
    private UserRequireLikeService userRequireLikeService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("finance:userrequirelike:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = userRequireLikeService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody UserRequireLikeForm userRequireLikeForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{openId}")
    public Result info(@PathVariable("openId") String openId){

        UserRequireLike userRequireLike = userRequireLikeService.getById(openId);

        return success(userRequireLike);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody UserRequireLikeForm userRequireLikeForm){

        UserRequireLike userRequireLike = new UserRequireLike();
        //Form --> domain
        BeanUtils.copyProperties(userRequireLikeForm,userRequireLike);

        userRequireLikeService.save(userRequireLike);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody UserRequireLike userRequireLike){

        userRequireLikeService.updateById(userRequireLike);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{openId}")
    public Result delete(@PathVariable("openId") String openId){

        userRequireLikeService.removeById(openId);

        return success();
    }

}
