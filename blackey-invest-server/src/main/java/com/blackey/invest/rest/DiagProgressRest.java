package com.blackey.invest.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.invest.component.domain.DiagProgress;
import com.blackey.invest.dto.form.DiagProgressForm;
import com.blackey.invest.component.service.DiagProgressService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 项目进展表 API REST
 *
 * @author kaven
 * @date 2018-11-05 10:02:16
 */
@RestController
@RequestMapping("/invest/diagprogress")
public class DiagProgressRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiagProgressRest.class);

    @Autowired
    private DiagProgressService diagProgressService;


    /**
    * 分页列表
    */
    @RequestMapping("/list/page")
    @RequiresPermissions("invest:diagprogress:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = diagProgressService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestBody DiagProgressForm diagProgressForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Long id){

        DiagProgress diagProgress = diagProgressService.getById(id);

        return success(diagProgress);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody DiagProgressForm diagProgressForm){

        DiagProgress diagProgress = new DiagProgress();
        //Form --> domain
        BeanUtils.copyProperties(diagProgressForm,diagProgress);

        diagProgressService.save(diagProgress);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody DiagProgress diagProgress){

        diagProgressService.updateById(diagProgress);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @RequestMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Long id){

        diagProgressService.removeById(id);

        return success();
    }

}
