package com.blackey.finance.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.finance.component.domain.Account;
import com.blackey.finance.dto.form.AccountForm;
import com.blackey.finance.component.service.AccountService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 账户信息表 API REST
 *
 * @author kaven
 * @date 2018-11-20 23:27:02
 */
@RestController
@RequestMapping("/finance/account")
public class AccountRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountRest.class);

    @Autowired
    private AccountService accountService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("finance:account:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = accountService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody AccountForm accountForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){

        Account account = accountService.getById(id);

        return success(account);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody AccountForm accountForm){

        Account account = new Account();
        //Form --> domain
        BeanUtils.copyProperties(accountForm,account);

        accountService.save(account);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody Account account){

        accountService.updateById(account);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable("id") String id){

        accountService.removeById(id);

        return success();
    }

}
