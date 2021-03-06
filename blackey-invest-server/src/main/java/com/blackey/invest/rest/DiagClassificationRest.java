package com.blackey.invest.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.invest.component.domain.DiagClassification;
import com.blackey.invest.dto.form.DiagClassificationForm;
import com.blackey.invest.component.service.DiagClassificationService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 项目分类 API REST
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@RestController
@RequestMapping("/invest/class")
public class DiagClassificationRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiagClassificationRest.class);

    @Autowired
    private DiagClassificationService diagClassificationService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("invest:diagclassification:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = diagClassificationService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody DiagClassificationForm diagClassificationForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id){

        DiagClassification diagClassification = diagClassificationService.getById(id);

        return success(diagClassification);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody DiagClassificationForm diagClassificationForm){

        DiagClassification diagClassification = new DiagClassification();
        //Form --> domain
        BeanUtils.copyProperties(diagClassificationForm,diagClassification);

        diagClassificationService.save(diagClassification);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody DiagClassification diagClassification){

        diagClassificationService.updateById(diagClassification);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Integer id){

        diagClassificationService.removeById(id);

        return success();
    }

}
