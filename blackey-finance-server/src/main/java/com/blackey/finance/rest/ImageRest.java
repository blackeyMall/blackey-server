package com.blackey.finance.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.finance.component.domain.Image;
import com.blackey.finance.dto.form.ImageForm;
import com.blackey.finance.component.service.ImageService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 图片表 API REST
 *
 * @author kaven
 * @date 2018-11-20 23:27:02
 */
@RestController
@RequestMapping("/finance/image")
public class ImageRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageRest.class);

    @Autowired
    private ImageService imageService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("finance:image:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = imageService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody ImageForm imageForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){

        Image image = imageService.getById(id);

        return success(image);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody ImageForm imageForm){

        Image image = new Image();
        //Form --> domain
        BeanUtils.copyProperties(imageForm,image);

        imageService.save(image);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody Image image){

        imageService.updateById(image);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable("id") String id){

        imageService.removeById(id);

        return success();
    }

}
