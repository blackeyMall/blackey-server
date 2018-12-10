package com.blackey.finance.rest;

import com.blackey.common.rest.BaseRest;
import com.blackey.finance.dto.form.AddOrCancelFollowForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.finance.component.domain.UserProjectLike;
import com.blackey.finance.dto.form.UserProjectLikeForm;
import com.blackey.finance.component.service.UserProjectLikeService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 用户点赞项目表 API REST
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@RestController
@RequestMapping("/finance/userprojectlike")
public class UserProjectLikeRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserProjectLikeRest.class);

    @Autowired
    private UserProjectLikeService userProjectLikeService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("finance:userprojectlike:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = userProjectLikeService.queryPage(params);

        return success(page);
    }


    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody AddOrCancelFollowForm addOrCancelFollowForm){


        userProjectLikeService.likeProject(addOrCancelFollowForm);

        return success();
    }


}
