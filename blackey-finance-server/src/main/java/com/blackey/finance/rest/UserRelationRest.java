package com.blackey.finance.rest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.common.rest.BaseRest;
import com.blackey.finance.global.constants.ApplyStatus;
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
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody UserRelationForm userRelationForm) {
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{openId}")
    public Result info(@PathVariable("openId") String openId) {

        UserRelation userRelation = userRelationService.getById(openId);

        return success(userRelation);
    }

    /**
     * 更新
     */
    @PostMapping("/update")
    public Result update(@RequestBody UserRelation userRelation) {

        userRelationService.updateById(userRelation);//全部更新

        return success();
    }


    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{openId}")
    public Result delete(@PathVariable("openId") String openId) {

        userRelationService.removeById(openId);

        return success();
    }

    /**
     * 申请好友
     */
    @PostMapping("/save")
    public Result save(@RequestBody UserRelationForm userRelationForm) {
        //校验两个用户是否是有效用户
        UserRelation userRelation = new UserRelation();
        //Form --> domain
        BeanUtils.copyProperties(userRelationForm, userRelation);

        userRelation.setStatus(ApplyStatus.APPLY);
        userRelationService.save(userRelation);

        return success();
    }


    @PostMapping("/list/page")
    @RequiresPermissions("finance:userrelation:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = userRelationService.queryPage(params);
        return success(page);
    }

    /**
     * 申请列表
     */
    @PostMapping("/list/openid")
    public Result listByOpenId(@RequestBody UserRelationForm form) {


        return success(userRelationService.queryPageByOpenId(form, new Page(form.getCurrent(), form.getSize())));
    }

    @PostMapping("/list/apply/openid")
    public Result listByOpenid(@RequestBody UserRelationForm form) {

        return success(userRelationService.queryApplyPageByOpenId(form, new Page(form.getCurrent(), form.getSize())));
    }

    /**
     * 通过
     */
    @PostMapping("/accept")
    public Result accept(@RequestBody UserRelationForm userRelationForm) {
        userRelationForm.setStatus(ApplyStatus.ACCEPT);

        userRelationService.updateByFriend(userRelationForm);//全部更新
        return success();
    }

    /**
     * 拒绝
     */
    @PostMapping("/refuse")
    public Result refuse(@RequestBody UserRelationForm userRelationForm) {
        userRelationForm.setStatus(ApplyStatus.REFUSE);
        userRelationService.updateByFriend(userRelationForm);//全部更新

        return success();
    }

    @PostMapping("/add")
    public Result add(@RequestBody UserRelationForm userRelationForm) {

        return userRelationService.addFriend(userRelationForm);
    }

    @GetMapping("/query")
    public Result query(UserRelationForm userRelationForm) {
        UserRelation userRelation = userRelationService.findRelation(userRelationForm);

        if (userRelation ==
                null) {
            return new Result<>(200,"不是好友关系");
        }
        if (userRelation.getStatus().equals(ApplyStatus.ACCEPT)) {
            return new Result<>(201,"已经是好友关系！");
        } else {
            if (userRelation.getOpenId().equals(userRelationForm.getOpenId())) {
                return new Result<>(202,"已发送好友申请给好友！");
            } else {
                return new Result<>(203,"申请列表中有该好友！");
            }
        }
    }
}
