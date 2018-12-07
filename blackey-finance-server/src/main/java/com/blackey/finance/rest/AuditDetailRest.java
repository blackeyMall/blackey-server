package com.blackey.finance.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.finance.component.domain.AuditDetail;
import com.blackey.finance.dto.form.AuditDetailForm;
import com.blackey.finance.component.service.AuditDetailService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 审批详情表 API REST
 *
 * @author kaven
 * @date 2018-12-07 09:48:54
 */
@RestController
@RequestMapping("/finance/auditdetail")
public class AuditDetailRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuditDetailRest.class);

    @Autowired
    private AuditDetailService auditDetailService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("finance:auditdetail:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = auditDetailService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody AuditDetailForm auditDetailForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{objectId}")
    public Result info(@PathVariable("objectId") String objectId){

        AuditDetail auditDetail = auditDetailService.getById(objectId);

        return success(auditDetail);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody AuditDetailForm auditDetailForm){

        AuditDetail auditDetail = new AuditDetail();
        //Form --> domain
        BeanUtils.copyProperties(auditDetailForm,auditDetail);

        auditDetailService.save(auditDetail);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody AuditDetail auditDetail){

        auditDetailService.updateById(auditDetail);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{objectId}")
    public Result delete(@PathVariable("objectId") String objectId){

        auditDetailService.removeById(objectId);

        return success();
    }

}
