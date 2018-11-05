package com.blackey.invest.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.invest.component.domain.DiagOrderInfo;
import com.blackey.invest.dto.form.DiagOrderInfoForm;
import com.blackey.invest.component.service.DiagOrderInfoService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 项目订单信息 API REST
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@RestController
@RequestMapping("/invest/diagorderinfo")
public class DiagOrderInfoRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiagOrderInfoRest.class);

    @Autowired
    private DiagOrderInfoService diagOrderInfoService;


    /**
    * 分页列表
    */
    @RequestMapping("/list/page")
    @RequiresPermissions("invest:diagorderinfo:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = diagOrderInfoService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestBody DiagOrderInfoForm diagOrderInfoForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id){

        DiagOrderInfo diagOrderInfo = diagOrderInfoService.getById(id);

        return success(diagOrderInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody DiagOrderInfoForm diagOrderInfoForm){

        DiagOrderInfo diagOrderInfo = new DiagOrderInfo();
        //Form --> domain
        BeanUtils.copyProperties(diagOrderInfoForm,diagOrderInfo);

        diagOrderInfoService.save(diagOrderInfo);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody DiagOrderInfo diagOrderInfo){

        diagOrderInfoService.updateById(diagOrderInfo);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @RequestMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Integer id){

        diagOrderInfoService.removeById(id);

        return success();
    }

}
