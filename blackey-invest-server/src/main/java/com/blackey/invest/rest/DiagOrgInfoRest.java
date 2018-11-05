package com.blackey.invest.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.invest.component.domain.DiagOrgInfo;
import com.blackey.invest.dto.form.DiagOrgInfoForm;
import com.blackey.invest.component.service.DiagOrgInfoService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 企业诊断机构信息 API REST
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@RestController
@RequestMapping("/invest/diagorginfo")
public class DiagOrgInfoRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiagOrgInfoRest.class);

    @Autowired
    private DiagOrgInfoService diagOrgInfoService;


    /**
    * 分页列表
    */
    @RequestMapping("/list/page")
    @RequiresPermissions("invest:diagorginfo:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = diagOrgInfoService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestBody DiagOrgInfoForm diagOrgInfoForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id){

        DiagOrgInfo diagOrgInfo = diagOrgInfoService.getById(id);

        return success(diagOrgInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody DiagOrgInfoForm diagOrgInfoForm){

        DiagOrgInfo diagOrgInfo = new DiagOrgInfo();
        //Form --> domain
        BeanUtils.copyProperties(diagOrgInfoForm,diagOrgInfo);

        diagOrgInfoService.save(diagOrgInfo);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody DiagOrgInfo diagOrgInfo){

        diagOrgInfoService.updateById(diagOrgInfo);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @RequestMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Integer id){

        diagOrgInfoService.removeById(id);

        return success();
    }

}
