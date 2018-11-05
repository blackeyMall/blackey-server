package com.blackey.invest.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.invest.component.domain.DiagEvaluateInfo;
import com.blackey.invest.dto.form.DiagEvaluateInfoForm;
import com.blackey.invest.component.service.DiagEvaluateInfoService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 投资人评价信息 API REST
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@RestController
@RequestMapping("/invest/diagevaluateinfo")
public class DiagEvaluateInfoRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiagEvaluateInfoRest.class);

    @Autowired
    private DiagEvaluateInfoService diagEvaluateInfoService;


    /**
    * 分页列表
    */
    @RequestMapping("/list/page")
    @RequiresPermissions("invest:diagevaluateinfo:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = diagEvaluateInfoService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestBody DiagEvaluateInfoForm diagEvaluateInfoForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Long id){

        DiagEvaluateInfo diagEvaluateInfo = diagEvaluateInfoService.getById(id);

        return success(diagEvaluateInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody DiagEvaluateInfoForm diagEvaluateInfoForm){

        DiagEvaluateInfo diagEvaluateInfo = new DiagEvaluateInfo();
        //Form --> domain
        BeanUtils.copyProperties(diagEvaluateInfoForm,diagEvaluateInfo);

        diagEvaluateInfoService.save(diagEvaluateInfo);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody DiagEvaluateInfo diagEvaluateInfo){

        diagEvaluateInfoService.updateById(diagEvaluateInfo);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @RequestMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Long id){

        diagEvaluateInfoService.removeById(id);

        return success();
    }

}
