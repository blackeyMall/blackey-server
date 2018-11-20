package com.blackey.finance.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.finance.component.domain.Requirement;
import com.blackey.finance.dto.form.RequirementForm;
import com.blackey.finance.component.service.RequirementService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 需求信息表 API REST
 *
 * @author kaven
 * @date 2018-11-20 23:27:03
 */
@RestController
@RequestMapping("/finance/requirement")
public class RequirementRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequirementRest.class);

    @Autowired
    private RequirementService requirementService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("finance:requirement:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = requirementService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody RequirementForm requirementForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){

        Requirement requirement = requirementService.getById(id);

        return success(requirement);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody RequirementForm requirementForm){

        Requirement requirement = new Requirement();
        //Form --> domain
        BeanUtils.copyProperties(requirementForm,requirement);

        requirementService.save(requirement);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody Requirement requirement){

        requirementService.updateById(requirement);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable("id") String id){

        requirementService.removeById(id);

        return success();
    }

}
