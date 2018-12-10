package com.blackey.finance.rest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.common.rest.BaseRest;
import com.blackey.finance.dto.bo.RequirementInfoBo;
import com.blackey.finance.dto.bo.UserRequireFollowBo;
import com.blackey.finance.dto.form.AddOrCancelFollowForm;
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

import java.util.List;
import java.util.Map;

/**
 * 用户需求关注表 API REST
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@RestController
@RequestMapping("/finance/follow/require")
public class UserRequireFollowRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRequireFollowRest.class);

    @Autowired
    private UserRequireFollowService userRequireFollowService;


    /**
    * 关注需求分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("finance:follow:require:list")
    public Result listPage(@RequestBody UserRequireFollowForm form){

        Page<UserRequireFollowBo> page = new Page<>(form.getCurrent(),form.getSize());

        List<UserRequireFollowBo> userRequireFollowBos = userRequireFollowService.queryPage(form,page);

        return success(page.setRecords(userRequireFollowBos));
    }

    /**
     * 保存---关注或取消需求
     */
    @PostMapping("/save")
    public Result save(@RequestBody AddOrCancelFollowForm form){

        boolean b = userRequireFollowService.addFollowNum(form);

        return success(b);
    }

}
