package com.blackey.bbs.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blackey.bbs.component.domain.UserInfo;
import com.blackey.bbs.component.service.UserInfoService;
import com.blackey.common.rest.BaseRest;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 会员用户信息表 API REST
 *
 * @author kaven
 * @date 2020-02-16 18:51:35
 */
@Api(value = "会员用户信息表",tags = {"会员用户信息表"})
@RestController
@RequestMapping("/bbs/userinfo")
public class UserInfoRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoRest.class);

    @Autowired
    private UserInfoService userInfoService;


    /**
    * 分页列表
    */
    @ApiOperation(value = "学堂banner信息表列表", notes = "学堂banner信息表列表")
    @PostMapping("/list/page")
    public Result list(@RequestParam(required = false) Map<String, Object> params){
        IPage iPage = userInfoService.queryPage(params);

        return success(iPage);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "学堂banner信息表列表", notes = "学堂banner信息表列表")
    public Result list(@RequestBody UserInfo userInfoForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{userName}")
    public Result info(@PathVariable("userName") String userName){

        UserInfo userInfo = userInfoService.getById(userName);

        return success(userInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody UserInfo userInfoForm){

        UserInfo userInfo = new UserInfo();
        //Form --> domain
        BeanUtils.copyProperties(userInfoForm,userInfo);

        userInfoService.save(userInfo);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "学堂banner信息表列表", notes = "学堂banner信息表列表")
    public Result update(@RequestBody UserInfo userInfo){

        userInfoService.updateById(userInfo);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{userName}")
    public Result delete(@PathVariable("userName") String userName){

        userInfoService.removeById(userName);

        return success();
    }

}
