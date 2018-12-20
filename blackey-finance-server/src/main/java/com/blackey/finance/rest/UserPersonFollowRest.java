package com.blackey.finance.rest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.common.rest.BaseRest;
import com.blackey.finance.component.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.finance.component.domain.UserPersonFollow;
import com.blackey.finance.dto.form.UserPersonFollowForm;
import com.blackey.finance.component.service.UserPersonFollowService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 用户关注用户表 API REST
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@RestController
@RequestMapping("/finance/userpersonfollow")
public class UserPersonFollowRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserPersonFollowRest.class);

    @Autowired
    private UserPersonFollowService userPersonFollowService;

    @Autowired
    private UserInfoService userInfoService;


    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody UserPersonFollowForm userPersonFollowForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{openId}")
    public Result info(@PathVariable("openId") String openId){

        UserPersonFollow userPersonFollow = userPersonFollowService.getById(openId);

        return success(userPersonFollow);
    }



    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody UserPersonFollow userPersonFollow){

        userPersonFollowService.updateById(userPersonFollow);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{openId}")
    public Result delete(@PathVariable("openId") String openId){
        userPersonFollowService.removeById(openId);

        return success();
    }


    /**
     * 用户关注
     */
    @PostMapping("/save")
    public Result save(@RequestBody UserPersonFollowForm userPersonFollowForm){

        UserPersonFollow userPersonFollow = new UserPersonFollow();
        //Form --> domain
        BeanUtils.copyProperties(userPersonFollowForm,userPersonFollow);

        userPersonFollowService.save(userPersonFollow);

        return success();
    }

    /**
     * 我关注的人列表
     */
    @PostMapping("/list/page")
    @RequiresPermissions("finance:userpersonfollow:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = userPersonFollowService.queryPage(params);

        return success(page);
    }

    /**
     * 我关注的人列表
     */
    @PostMapping("/list/openid")
    public Result listByOpenid(@RequestBody UserPersonFollowForm form, Page page){
        return success(userPersonFollowService.queryByOpenid(form,page));
    }

}
