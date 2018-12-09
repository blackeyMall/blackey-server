package com.blackey.finance.rest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.common.rest.BaseRest;
import com.blackey.finance.dto.bo.UserProjectFollowBo;
import com.blackey.finance.dto.bo.UserRequireFollowBo;
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
@RequestMapping("/finance/userprojectfollow")
public class UserProjectFollowRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserProjectFollowRest.class);

    @Autowired
    private UserProjectFollowService userProjectFollowService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("finance:userprojectfollow:list")
    public Result listPage(@RequestBody UserProjectFollowForm form){

        Page<UserProjectFollowBo> page = new Page<>(form.getCurrent(),form.getSize());

        List<UserProjectFollowBo> userProjectFollowBos = userProjectFollowService.queryPage(form,page);

        return success(page.setRecords(userProjectFollowBos));
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody UserProjectFollowForm userProjectFollowForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{openId}")
    public Result info(@PathVariable("openId") String openId){

        UserProjectFollow userProjectFollow = userProjectFollowService.getById(openId);

        return success(userProjectFollow);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody UserProjectFollowForm userProjectFollowForm){

        UserProjectFollow userProjectFollow = new UserProjectFollow();
        //Form --> domain
        BeanUtils.copyProperties(userProjectFollowForm,userProjectFollow);

        userProjectFollowService.save(userProjectFollow);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody UserProjectFollow userProjectFollow){

        userProjectFollowService.updateById(userProjectFollow);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{openId}")
    public Result delete(@PathVariable("openId") String openId){

        userProjectFollowService.removeById(openId);

        return success();
    }

}
