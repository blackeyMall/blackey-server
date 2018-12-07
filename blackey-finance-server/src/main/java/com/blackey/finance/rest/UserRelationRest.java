package com.blackey.finance.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.finance.component.domain.UserRelation;
import com.blackey.finance.dto.form.UserRelationForm;
import com.blackey.finance.component.service.UserRelationService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 用户好友关联表 API REST
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@RestController
@RequestMapping("/finance/userrelation")
public class UserRelationRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRelationRest.class);

    @Autowired
    private UserRelationService userRelationService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("finance:userrelation:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = userRelationService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody UserRelationForm userRelationForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{openId}")
    public Result info(@PathVariable("openId") String openId){

        UserRelation userRelation = userRelationService.getById(openId);

        return success(userRelation);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody UserRelationForm userRelationForm){

        UserRelation userRelation = new UserRelation();
        //Form --> domain
        BeanUtils.copyProperties(userRelationForm,userRelation);

        userRelationService.save(userRelation);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody UserRelation userRelation){

        userRelationService.updateById(userRelation);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{openId}")
    public Result delete(@PathVariable("openId") String openId){

        userRelationService.removeById(openId);

        return success();
    }

}
