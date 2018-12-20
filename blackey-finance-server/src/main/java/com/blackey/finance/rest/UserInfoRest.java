package com.blackey.finance.rest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.common.rest.BaseRest;
import com.blackey.finance.dto.bo.UserInfoBo;
import com.blackey.wx.bean.WxEncyptBean;
import me.chanjar.weixin.common.error.WxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.finance.component.domain.UserInfo;
import com.blackey.finance.dto.form.UserInfoForm;
import com.blackey.finance.component.service.UserInfoService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 用户信息表 API REST
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@RestController
@RequestMapping("/finance/userinfo")
public class UserInfoRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoRest.class);

    @Autowired
    private UserInfoService userInfoService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("finance:userinfo:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = userInfoService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody UserInfoForm userInfoForm){
        //TODO
        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody UserInfo userInfo){

        userInfoService.updateById(userInfo);//全部更新
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{telephone}")
    public Result delete(@PathVariable("telephone") String telephone){

        userInfoService.removeById(telephone);
        return success();
    }


    /**
     * 微信登录
     * @param code
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public Result login(String code, HttpServletRequest request){
        try {
            return success(userInfoService.login(request,code));
        } catch (WxErrorException e){
            return failure(e.getMessage());
        }
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody UserInfoForm userInfoForm){

        UserInfo userInfo = new UserInfo();
        //Form --> domain
        BeanUtils.copyProperties(userInfoForm,userInfo);
        userInfoService.save(userInfo);
        return success();
    }


    /**
     * 获取手机号
     */
    @PostMapping("/phone")
    public  Result getTelephone(@RequestBody WxEncyptBean wxEncyptBean){
        return success(userInfoService.getPhoneNumber(wxEncyptBean));
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{openid}")
    public Result info(@PathVariable("openid") String openid){

        UserInfoBo userInfobo = userInfoService.findByOpenId(openid);
        return success(userInfobo);
    }

    /**
     * 查询无关系的用户
     */
    @GetMapping("/list/user")
    public Result userWithoutRelation(@RequestParam String openid,Page page){

        return success(userInfoService.queryUserWithoutRelation(openid,page));
    }


}
