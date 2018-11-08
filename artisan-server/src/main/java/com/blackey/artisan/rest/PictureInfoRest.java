package com.blackey.artisan.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.artisan.component.domain.PictureInfo;
import com.blackey.artisan.dto.form.PictureInfoForm;
import com.blackey.artisan.component.service.PictureInfoService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 *  API REST
 *
 * @author kavenW
 * @date 2018-11-07 19:42:29
 */
@RestController
@RequestMapping("/artisan/pictureinfo")
public class PictureInfoRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PictureInfoRest.class);

    @Autowired
    private PictureInfoService pictureInfoService;


    /**
    * 分页列表
    */
    @RequestMapping("/list/page")
    @RequiresPermissions("artisan:pictureinfo:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = pictureInfoService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestBody PictureInfoForm pictureInfoForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){

        PictureInfo pictureInfo = pictureInfoService.getById(id);

        return success(pictureInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody PictureInfoForm pictureInfoForm){

        PictureInfo pictureInfo = new PictureInfo();
        //Form --> domain
        BeanUtils.copyProperties(pictureInfoForm,pictureInfo);

        pictureInfoService.save(pictureInfo);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody PictureInfo pictureInfo){

        pictureInfoService.updateById(pictureInfo);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @RequestMapping("/delete/{id}")
    public Result delete(@PathVariable("id") String id){

        pictureInfoService.removeById(id);

        return success();
    }

}
