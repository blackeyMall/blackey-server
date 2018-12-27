package com.blackey.finance.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.finance.component.domain.AccountDetail;
import com.blackey.finance.dto.form.AccountDetailForm;
import com.blackey.finance.component.service.AccountDetailService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 账户流水明细表 API REST
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@RestController
@RequestMapping("/finance/accountdetail")
public class AccountDetailRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountDetailRest.class);

    @Autowired
    private AccountDetailService accountDetailService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("finance:accountdetail:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = accountDetailService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody AccountDetailForm accountDetailForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{openId}")
    public Result info(@PathVariable("openId") String openId){

        AccountDetail accountDetail = accountDetailService.getById(openId);

        return success(accountDetail);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody AccountDetailForm accountDetailForm){

        AccountDetail accountDetail = new AccountDetail();
        //Form --> domain
        BeanUtils.copyProperties(accountDetailForm,accountDetail);

        accountDetailService.save(accountDetail);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody AccountDetail accountDetail){

        accountDetailService.updateById(accountDetail);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{openId}")
    public Result delete(@PathVariable("openId") String openId){

        accountDetailService.removeById(openId);

        return success();
    }

}
