package com.blackey.finance.rest;

import com.blackey.common.rest.BaseRest;
import com.blackey.finance.dto.form.AddOrCancelFollowForm;
import com.blackey.finance.global.constants.AddCancelEnum;
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
    * 分页列表--我点赞的需求
    */
    @PostMapping("/list/page")
    @RequiresPermissions("finance:userrequirelike:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = userRequireLikeService.queryPage(params);

        return success(page);
    }

    /**
     * 保存----点赞或取消点赞
     */
    @PostMapping("/save")
    public Result save(@RequestBody AddOrCancelFollowForm addOrCancelFollowForm){

        AddCancelEnum addCancelEnum = userRequireLikeService.likeRequire(addOrCancelFollowForm);

        return success(addCancelEnum);
    }


}
