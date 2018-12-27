package com.blackey.finance.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.finance.component.domain.ImageInfo;
import com.blackey.finance.dto.form.ImageInfoForm;
import com.blackey.finance.component.service.ImageInfoService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 图片表 API REST
 *
 * @author kaven
 * @date 2018-12-07 09:48:53
 */
@RestController
@RequestMapping("/finance/imageinfo")
public class ImageInfoRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageInfoRest.class);

    @Autowired
    private ImageInfoService imageInfoService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("finance:imageinfo:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = imageInfoService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody ImageInfoForm imageInfoForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{imageType}")
    public Result info(@PathVariable("imageType") String imageType){

        ImageInfo imageInfo = imageInfoService.getById(imageType);

        return success(imageInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody ImageInfoForm imageInfoForm){

        ImageInfo imageInfo = new ImageInfo();
        //Form --> domain
        BeanUtils.copyProperties(imageInfoForm,imageInfo);

        imageInfoService.save(imageInfo);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody ImageInfo imageInfo){

        imageInfoService.updateById(imageInfo);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{imageType}")
    public Result delete(@PathVariable("imageType") String imageType){

        imageInfoService.removeById(imageType);

        return success();
    }

}
