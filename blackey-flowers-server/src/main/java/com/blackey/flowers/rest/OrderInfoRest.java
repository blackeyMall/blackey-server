package com.blackey.flowers.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.flowers.component.domain.OrderInfo;
import com.blackey.flowers.dto.form.OrderInfoForm;
import com.blackey.flowers.component.service.OrderInfoService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 订单信息表 API REST
 *
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
@RestController
@RequestMapping("/flowers/orderinfo")
public class OrderInfoRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderInfoRest.class);

    @Autowired
    private OrderInfoService orderInfoService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("flowers:orderinfo:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = orderInfoService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody OrderInfoForm orderInfoForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") Long id){

        OrderInfo orderInfo = orderInfoService.getById(id);

        return success(orderInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody OrderInfoForm orderInfoForm){

        OrderInfo orderInfo = new OrderInfo();
        //Form --> domain
        BeanUtils.copyProperties(orderInfoForm,orderInfo);

        orderInfoService.save(orderInfo);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody OrderInfo orderInfo){

        orderInfoService.updateById(orderInfo);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Long id){

        orderInfoService.removeById(id);

        return success();
    }

}
