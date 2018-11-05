package com.blackey.invest.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.invest.component.domain.DiagAudirecord;
import com.blackey.invest.dto.form.DiagAudirecordForm;
import com.blackey.invest.component.service.DiagAudirecordService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 管理员审核记录信息 API REST
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@RestController
@RequestMapping("/invest/record")
public class DiagAudirecordRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiagAudirecordRest.class);

    @Autowired
    private DiagAudirecordService diagAudirecordService;


    /**
    * 分页列表
    */
    @RequestMapping("/list/page")
    @RequiresPermissions("invest:diagaudirecord:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = diagAudirecordService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestBody DiagAudirecordForm diagAudirecordForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id){

        DiagAudirecord diagAudirecord = diagAudirecordService.getById(id);

        return success(diagAudirecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody DiagAudirecordForm diagAudirecordForm){

        DiagAudirecord diagAudirecord = new DiagAudirecord();
        //Form --> domain
        BeanUtils.copyProperties(diagAudirecordForm,diagAudirecord);

        diagAudirecordService.save(diagAudirecord);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody DiagAudirecord diagAudirecord){

        diagAudirecordService.updateById(diagAudirecord);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @RequestMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Integer id){

        diagAudirecordService.removeById(id);

        return success();
    }

}
