package com.blackey.finance.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.finance.component.domain.RequirementInfo;
import com.blackey.finance.dto.form.RequirementInfoForm;
import com.blackey.finance.component.service.RequirementInfoService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 需求信息表 API REST
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@RestController
@RequestMapping("/finance/requirementinfo")
public class RequirementInfoRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequirementInfoRest.class);

    @Autowired
    private RequirementInfoService requirementInfoService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("finance:requirementinfo:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = requirementInfoService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody RequirementInfoForm requirementInfoForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{titile}")
    public Result info(@PathVariable("titile") String titile){

        RequirementInfo requirementInfo = requirementInfoService.getById(titile);

        return success(requirementInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody RequirementInfoForm requirementInfoForm){

        RequirementInfo requirementInfo = new RequirementInfo();
        //Form --> domain
        BeanUtils.copyProperties(requirementInfoForm,requirementInfo);

        requirementInfoService.save(requirementInfo);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody RequirementInfo requirementInfo){

        requirementInfoService.updateById(requirementInfo);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{titile}")
    public Result delete(@PathVariable("titile") String titile){

        requirementInfoService.removeById(titile);

        return success();
    }

}
