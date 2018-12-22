package com.blackey.finance.rest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.common.rest.BaseRest;
import com.blackey.finance.dto.bo.UserProjectFollowBo;
import com.blackey.finance.dto.bo.UserRequireFollowBo;
import com.blackey.finance.dto.form.AddOrCancelFollowForm;
import com.blackey.finance.global.constants.AddCancelEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.finance.component.domain.UserProjectFollow;
import com.blackey.finance.dto.form.UserProjectFollowForm;
import com.blackey.finance.component.service.UserProjectFollowService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 用户关注项目表 API REST
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@RestController
@RequestMapping("/finance/follow/project")
public class UserProjectFollowRest extends BaseRest {


    @Autowired
    private UserProjectFollowService userProjectFollowService;

    /**
    * 分页列表--我关注的项目
    */
    @PostMapping("/list/page")
    @RequiresPermissions("finance:follow:project:list")
    public Result listPage(@RequestBody UserProjectFollowForm form){

        Page<UserProjectFollowBo> page = new Page<>(form.getCurrent(),form.getSize());

        //List<UserProjectFollowBo> userProjectFollowBos = userProjectFollowService.queryPage(form,page);

        return success();
    }

    /**
     * 保存--关注/取消项目
     */
    @PostMapping("/save")
    public Result save(@RequestBody AddOrCancelFollowForm addOrCancelFollowForm){

        AddCancelEnum addCancelEnum = userProjectFollowService.followProject(addOrCancelFollowForm);

        return success(addCancelEnum);
    }


}
