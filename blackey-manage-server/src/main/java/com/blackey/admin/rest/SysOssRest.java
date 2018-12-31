package com.blackey.admin.rest;

import com.blackey.admin.component.domain.SysOss;
import com.blackey.admin.component.service.SysOssService;
import com.blackey.admin.dto.form.SysOssForm;
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
 * 文件上传 API REST
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@RestController
@RequestMapping("/admin/sysoss")
public class SysOssRest extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysOssRest.class);

    @Autowired
    private SysOssService sysOssService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("admin:sysoss:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = sysOssService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody SysOssForm sysOssForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{url}")
    public Result info(@PathVariable("url") String url){

        SysOss sysOss = sysOssService.getById(url);

        return success(sysOss);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody SysOssForm sysOssForm){

        SysOss sysOss = new SysOss();
        //Form --> domain
        BeanUtils.copyProperties(sysOssForm,sysOss);

        sysOssService.save(sysOss);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody SysOss sysOss){

        sysOssService.updateById(sysOss);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{url}")
    public Result delete(@PathVariable("url") String url){

        sysOssService.removeById(url);

        return success();
    }

}
