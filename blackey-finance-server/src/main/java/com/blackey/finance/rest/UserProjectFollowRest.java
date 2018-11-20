package com.blackey.finance.rest;

import com.blackey.common.rest.BaseRest;
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

import java.util.Map;

/**
 * 用户关注项目表 API REST
 *
 * @author kaven
 * @date 2018-11-20 23:27:03
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
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = userProjectFollowService.queryPage(params);

        return success(page);
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
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){

        UserProjectFollow userProjectFollow = userProjectFollowService.getById(id);

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
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable("id") String id){

        userProjectFollowService.removeById(id);

        return success();
    }

}
