package com.blackey.bbs.web;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.bbs.component.domain.AccountInfo;
import com.blackey.bbs.component.service.AccountInfoService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 会员登录信息表 API REST
 *
 * @author kaven
 * @date 2020-02-16 18:51:35
 */
@RestController
@RequestMapping("/bbs/accountinfo")
public class AccountInfoRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountInfoRest.class);

    @Autowired
    private AccountInfoService accountInfoService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("bbs:accountinfo:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = accountInfoService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody AccountInfo accountInfoForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{account}")
    public Result info(@PathVariable("account") String account){

        AccountInfo accountInfo = accountInfoService.getById(account);

        return success(accountInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody AccountInfo accountInfoForm){

        AccountInfo accountInfo = new AccountInfo();
        //Form --> domain
        BeanUtils.copyProperties(accountInfoForm,accountInfo);

        accountInfoService.save(accountInfo);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody AccountInfo accountInfo){

        accountInfoService.updateById(accountInfo);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{account}")
    public Result delete(@PathVariable("account") String account){

        accountInfoService.removeById(account);

        return success();
    }

}
