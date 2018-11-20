package com.blackey.finance.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.finance.component.domain.UserRequireFollow;
import com.blackey.finance.dto.form.UserRequireFollowForm;
import com.blackey.finance.component.service.UserRequireFollowService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 用户需求关注表 API REST
 *
 * @author kaven
 * @date 2018-11-20 23:27:03
 */
@RestController
@RequestMapping("/finance/userrequirefollow")
public class UserRequireFollowRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRequireFollowRest.class);

    @Autowired
    private UserRequireFollowService userRequireFollowService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("finance:userrequirefollow:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = userRequireFollowService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody UserRequireFollowForm userRequireFollowForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){

        UserRequireFollow userRequireFollow = userRequireFollowService.getById(id);

        return success(userRequireFollow);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody UserRequireFollowForm userRequireFollowForm){

        UserRequireFollow userRequireFollow = new UserRequireFollow();
        //Form --> domain
        BeanUtils.copyProperties(userRequireFollowForm,userRequireFollow);

        userRequireFollowService.save(userRequireFollow);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody UserRequireFollow userRequireFollow){

        userRequireFollowService.updateById(userRequireFollow);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable("id") String id){

        userRequireFollowService.removeById(id);

        return success();
    }

}
