package com.blackey.finance.rest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.common.rest.BaseRest;
import com.blackey.common.result.Result;
import com.blackey.finance.component.domain.AuditDetail;
import com.blackey.finance.component.service.AuditDetailService;
import com.blackey.finance.dto.bo.AuditDetailBo;
import com.blackey.finance.dto.form.AuditDetailForm;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 审批详情表 API REST
 *
 * @author kaven
 * @date 2018-12-07 09:48:54
 */
@RestController
@RequestMapping("/finance/audit")
public class AuditDetailRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuditDetailRest.class);

    @Autowired
    private AuditDetailService auditDetailService;


    /**
    * 分页列表--我的审批
    */
    @PostMapping("/list/page")
    //@RequiresPermissions("finance:audit:list")
    public Result listPage(@RequestBody AuditDetailForm form){

        IPage<AuditDetail> detailIPage = auditDetailService.queryPage(form, new Page<>(form.getCurrent(),form.getSize()));

        return success(detailIPage);
    }

    /**
     * 列表--待审批列表
     */
    @PostMapping("/list")
    @RequiresPermissions("finance:audit:list")
    public Result list(@RequestBody AuditDetailForm form){

        Page<AuditDetailBo> page = new Page<>(form.getCurrent(),form.getSize());
        List<AuditDetailBo> auditDetailBoList = auditDetailService.queryListPage(form,page);

        return success(page.setRecords(auditDetailBoList));
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("finance:audit:info")
    public Result info(@PathVariable("id") String id){

        AuditDetail auditDetail = auditDetailService.getById(id);

        return success(auditDetail);
    }

    /**
     * 修改--审批
     */
    @PostMapping("/update")
    @RequiresPermissions("finance:audit:update")
    public Result update(@RequestBody AuditDetail auditDetail){

        auditDetailService.audit(auditDetail);

        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{id}")
    @RequiresPermissions("finance:audit:delete")
    public Result delete(@PathVariable("id") String id){

        auditDetailService.removeById(id);

        return success();
    }

}
