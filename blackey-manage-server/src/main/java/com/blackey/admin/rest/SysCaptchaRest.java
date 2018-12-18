package com.blackey.admin.rest;

import com.blackey.admin.component.domain.SysCaptcha;
import com.blackey.admin.component.service.SysCaptchaService;
import com.blackey.admin.dto.form.SysCaptchaForm;
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
 * 系统验证码 API REST
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@RestController
@RequestMapping("/admin/syscaptcha")
public class SysCaptchaRest extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysCaptchaRest.class);

    @Autowired
    private SysCaptchaService sysCaptchaService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("admin:syscaptcha:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = sysCaptchaService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody SysCaptchaForm sysCaptchaForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{uuid}")
    public Result info(@PathVariable("uuid") String uuid){

        SysCaptcha sysCaptcha = sysCaptchaService.getById(uuid);

        return success(sysCaptcha);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody SysCaptchaForm sysCaptchaForm){

        SysCaptcha sysCaptcha = new SysCaptcha();
        //Form --> domain
        BeanUtils.copyProperties(sysCaptchaForm,sysCaptcha);

        sysCaptchaService.save(sysCaptcha);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody SysCaptcha sysCaptcha){

        sysCaptchaService.updateById(sysCaptcha);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{uuid}")
    public Result delete(@PathVariable("uuid") String uuid){

        sysCaptchaService.removeById(uuid);

        return success();
    }

}
