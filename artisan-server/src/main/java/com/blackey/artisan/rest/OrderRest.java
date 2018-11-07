package com.blackey.artisan.rest;

import com.blackey.artisan.dto.bo.OrderInfoBo;
import com.blackey.common.rest.BaseRest;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.artisan.component.domain.Order;
import com.blackey.artisan.dto.form.OrderForm;
import com.blackey.artisan.component.service.OrderService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 *  API REST
 *
 * @author kavenW
 * @date 2018-11-04 21:12:24
 */
@RestController
@RequestMapping("/artisan/order")
public class OrderRest extends BaseRest {

    @Autowired
    private OrderService orderService;


    /**
    * 分页列表
    */
    @RequestMapping("/list/page")
    @RequiresPermissions("artisan:order:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = orderService.queryPage(params);
        return success(page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestBody OrderForm orderForm){
        //TODO
        return success();
    }




    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody OrderForm orderForm){

        Order order = new Order();
        //Form --> domain
        BeanUtils.copyProperties(orderForm,order);

        orderService.save(order);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody Order order){

        orderService.updateById(order);
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @RequestMapping("/delete/{id}")
    public Result delete(@PathVariable("id") String id){

        orderService.removeById(id);
        return success();
    }

    @GetMapping("/main/order")
    public List<OrderInfoBo> listOrderInfo(OrderForm form){
        return orderService.getMainPageOrderList(form);
    }

    @PostMapping("/booking")
    public Result booking(OrderForm form){
        orderService.bookingService(form);
        return success();
    }

    @PostMapping("/confirm")
    public Result confirm(@RequestBody OrderForm form){
        orderService.confirmService(form);
        return success();
    }

    @RequestMapping("/detail/{id}")
    public Result info(@PathVariable("id") String id){
        return success(orderService.detail(id));
    }

}
