package com.blackey.flowers.rest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.common.rest.BaseRest;
import com.blackey.flowers.dto.bo.RefereeInfoBo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.flowers.component.domain.RefereeInfo;
import com.blackey.flowers.dto.form.RefereeInfoForm;
import com.blackey.flowers.component.service.RefereeInfoService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;
import java.util.UUID;

/**
 *  API REST
 *
 * @author kaven
 * @date 2018-11-28 20:43:34
 */
@RestController
@RequestMapping("/flowers/referee")
public class RefereeInfoRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefereeInfoRest.class);

    @Autowired
    private RefereeInfoService refereeInfoService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("flowers:referee:list")
    public Result listPage(@RequestBody RefereeInfoForm refereeInfoForm){

        Page<RefereeInfoBo> page = new Page<>(refereeInfoForm.getCurrent(),refereeInfoForm.getSize());

        return success(page.setRecords(refereeInfoService.queryPage(refereeInfoForm,page)));
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    @RequiresPermissions("flowers:referee:list")
    public Result list(@RequestBody RefereeInfoForm refereeInfoForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("flowers:referee:info")
    public Result info(@PathVariable("id") String id){

        RefereeInfo refereeInfo = refereeInfoService.getById(id);

        return success(refereeInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("flowers:referee:save")
    public Result save(@RequestBody RefereeInfoForm refereeInfoForm){

        RefereeInfo refereeInfo = new RefereeInfo();
        //Form --> domain
        BeanUtils.copyProperties(refereeInfoForm,refereeInfo);
        refereeInfo.setId(UUID.randomUUID().toString().replace("-",""));
        refereeInfoService.save(refereeInfo);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("flowers:referee:update")
    public Result update(@RequestBody RefereeInfo refereeInfo){

        refereeInfoService.updateById(refereeInfo);
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{id}")
    @RequiresPermissions("flowers:referee:delete")
    public Result delete(@PathVariable("id") String id){

        refereeInfoService.removeById(id);

        return success();
    }

}
