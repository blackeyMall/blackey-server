package com.blackey.artisan.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.artisan.component.domain.ShareRelation;
import com.blackey.artisan.dto.form.ShareRelationForm;
import com.blackey.artisan.component.service.ShareRelationService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import javax.validation.Valid;
import java.util.Map;

/**
 *  API REST
 *
 * @author kaven
 * @date 2019-01-02 13:47:16
 */
@RestController
@RequestMapping("/artisan/sharerelation")
public class ShareRelationRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShareRelationRest.class);

    @Autowired
    private ShareRelationService shareRelationService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("artisan:sharerelation:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = shareRelationService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody ShareRelationForm shareRelationForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{userOpenid}")
    public Result info(@PathVariable("userOpenid") String userOpenid){

        ShareRelation shareRelation = shareRelationService.getById(userOpenid);

        return success(shareRelation);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody @Valid ShareRelationForm shareRelationForm){
        if (!"".equals(shareRelationService.exsitParent(shareRelationForm.getOpenid()))){
            return failure("已有好友关系！");
        }

        ShareRelation shareRelation = new ShareRelation();
        //Form --> domain
        BeanUtils.copyProperties(shareRelationForm,shareRelation);
        shareRelationService.save(shareRelation);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody ShareRelation shareRelation){

        shareRelationService.updateById(shareRelation);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{userOpenid}")
    public Result delete(@PathVariable("userOpenid") String userOpenid){

        shareRelationService.removeById(userOpenid);

        return success();
    }

}
