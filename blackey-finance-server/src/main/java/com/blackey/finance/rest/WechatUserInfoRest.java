package com.blackey.finance.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.finance.component.domain.WechatUserInfo;
import com.blackey.finance.dto.form.WechatUserInfoForm;
import com.blackey.finance.component.service.WechatUserInfoService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 微信用户信息表 API REST
 *
 * @author kaven
 * @date 2018-12-07 13:53:50
 */
@RestController
@RequestMapping("/finance/wechatuserinfo")
public class WechatUserInfoRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatUserInfoRest.class);

    @Autowired
    private WechatUserInfoService wechatUserInfoService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("finance:wechatuserinfo:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = wechatUserInfoService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody WechatUserInfoForm wechatUserInfoForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{city}")
    public Result info(@PathVariable("city") String city){

        WechatUserInfo wechatUserInfo = wechatUserInfoService.getById(city);

        return success(wechatUserInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody WechatUserInfoForm wechatUserInfoForm){

        WechatUserInfo wechatUserInfo = new WechatUserInfo();
        //Form --> domain
        BeanUtils.copyProperties(wechatUserInfoForm,wechatUserInfo);

        wechatUserInfoService.save(wechatUserInfo);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody WechatUserInfo wechatUserInfo){

        wechatUserInfoService.updateById(wechatUserInfo);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{city}")
    public Result delete(@PathVariable("city") String city){

        wechatUserInfoService.removeById(city);

        return success();
    }

}
