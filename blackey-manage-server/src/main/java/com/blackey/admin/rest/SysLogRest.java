package com.blackey.admin.rest;

import com.blackey.admin.component.domain.SysLog;
import com.blackey.admin.component.service.SysLogService;
import com.blackey.admin.dto.form.SysLogForm;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 系统日志 API REST
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@RestController
@RequestMapping("/admin/syslog")
public class SysLogRest extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysLogRest.class);

    @Autowired
    private SysLogService sysLogService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("admin:syslog:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = sysLogService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody SysLogForm sysLogForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{username}")
    public Result info(@PathVariable("username") String username){

        SysLog sysLog = sysLogService.getById(username);

        return success(sysLog);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody SysLogForm sysLogForm){

        SysLog sysLog = new SysLog();
        //Form --> domain
        BeanUtils.copyProperties(sysLogForm,sysLog);

        sysLogService.save(sysLog);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody SysLog sysLog){

        sysLogService.updateById(sysLog);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{username}")
    public Result delete(@PathVariable("username") String username){

        sysLogService.removeById(username);

        return success();
    }

}
