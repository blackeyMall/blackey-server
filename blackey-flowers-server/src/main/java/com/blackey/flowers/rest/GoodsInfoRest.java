package com.blackey.flowers.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.flowers.component.domain.GoodsInfo;
import com.blackey.flowers.dto.form.GoodsInfoForm;
import com.blackey.flowers.component.service.GoodsInfoService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 商品表 API REST
 *
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
@RestController
@RequestMapping("/flowers/goodsinfo")
public class GoodsInfoRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsInfoRest.class);

    @Autowired
    private GoodsInfoService goodsInfoService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("flowers:goodsinfo:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsInfoService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody GoodsInfoForm goodsInfoForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") Long id){

        GoodsInfo goodsInfo = goodsInfoService.getById(id);

        return success(goodsInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody GoodsInfoForm goodsInfoForm){

        GoodsInfo goodsInfo = new GoodsInfo();
        //Form --> domain
        BeanUtils.copyProperties(goodsInfoForm,goodsInfo);

        goodsInfoService.save(goodsInfo);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody GoodsInfo goodsInfo){

        goodsInfoService.updateById(goodsInfo);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Long id){

        goodsInfoService.removeById(id);

        return success();
    }

}
