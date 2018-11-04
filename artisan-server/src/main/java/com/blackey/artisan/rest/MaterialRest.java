package com.blackey.artisan.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.artisan.component.domain.Material;
import com.blackey.artisan.dto.form.MaterialForm;
import com.blackey.artisan.component.service.MaterialService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 *  API REST
 *
 * @author kavenW
 * @date 2018-11-04 12:10:24
 */
@RestController
@RequestMapping("artisan/material")
public class MaterialRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MaterialRest.class);

    @Autowired
    private MaterialService materialService;


    /**
    * 分页列表
    */
    @RequestMapping("/list/page")
    @RequiresPermissions("artisan:material:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = materialService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestBody MaterialForm materialForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){

        Material material = materialService.getById(id);

        return success(material);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody MaterialForm materialForm){

        Material material = new Material();
        //Form --> domain
        BeanUtils.copyProperties(materialForm,material);

        materialService.save(material);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody Material material){

        materialService.updateById(material);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @RequestMapping("/delete/{id}")
    public Result delete(@PathVariable("id") String id){

        materialService.removeById(id);

        return success();
    }

}
