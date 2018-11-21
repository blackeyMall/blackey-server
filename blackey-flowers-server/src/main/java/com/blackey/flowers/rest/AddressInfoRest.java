package com.blackey.flowers.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.flowers.component.domain.AddressInfo;
import com.blackey.flowers.dto.form.AddressInfoForm;
import com.blackey.flowers.component.service.AddressInfoService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 收货地址信息表 API REST
 *
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
@RestController
@RequestMapping("/flowers/addressinfo")
public class AddressInfoRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressInfoRest.class);

    @Autowired
    private AddressInfoService addressInfoService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("flowers:addressinfo:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = addressInfoService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody AddressInfoForm addressInfoForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") Long id){

        AddressInfo addressInfo = addressInfoService.getById(id);

        return success(addressInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody AddressInfoForm addressInfoForm){

        AddressInfo addressInfo = new AddressInfo();
        //Form --> domain
        BeanUtils.copyProperties(addressInfoForm,addressInfo);

        addressInfoService.save(addressInfo);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody AddressInfo addressInfo){

        addressInfoService.updateById(addressInfo);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Long id){

        addressInfoService.removeById(id);

        return success();
    }

}
