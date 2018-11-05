package com.blackey.invest.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.invest.component.domain.DiagProjecsetmeet;
import com.blackey.invest.dto.form.DiagProjecsetmeetForm;
import com.blackey.invest.component.service.DiagProjecsetmeetService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 项目套餐信息描述 API REST
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@RestController
@RequestMapping("/invest/diagprojecsetmeet")
public class DiagProjecsetmeetRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiagProjecsetmeetRest.class);

    @Autowired
    private DiagProjecsetmeetService diagProjecsetmeetService;


    /**
    * 分页列表
    */
    @RequestMapping("/list/page")
    @RequiresPermissions("invest:diagprojecsetmeet:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = diagProjecsetmeetService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestBody DiagProjecsetmeetForm diagProjecsetmeetForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Long id){

        DiagProjecsetmeet diagProjecsetmeet = diagProjecsetmeetService.getById(id);

        return success(diagProjecsetmeet);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody DiagProjecsetmeetForm diagProjecsetmeetForm){

        DiagProjecsetmeet diagProjecsetmeet = new DiagProjecsetmeet();
        //Form --> domain
        BeanUtils.copyProperties(diagProjecsetmeetForm,diagProjecsetmeet);

        diagProjecsetmeetService.save(diagProjecsetmeet);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody DiagProjecsetmeet diagProjecsetmeet){

        diagProjecsetmeetService.updateById(diagProjecsetmeet);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @RequestMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Long id){

        diagProjecsetmeetService.removeById(id);

        return success();
    }

}
