package com.blackey.finance.rest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.common.rest.BaseRest;
import com.blackey.finance.dto.bo.ProjectInfoBo;
import com.blackey.finance.dto.bo.RequirementInfoBo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.finance.component.domain.ProjectInfo;
import com.blackey.finance.dto.form.ProjectInfoForm;
import com.blackey.finance.component.service.ProjectInfoService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 项目信息表 API REST
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@RestController
@RequestMapping("/finance/projectinfo")
public class ProjectInfoRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectInfoRest.class);

    @Autowired
    private ProjectInfoService projectInfoService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("finance:projectinfo:list")
    public Result listPage(@RequestBody ProjectInfoForm form){

        Page<ProjectInfoBo> page = new Page<>(form.getCurrent(),form.getSize());

        List<ProjectInfoBo> projectInfoBos = projectInfoService.queryPage(form,page);

        return success(page.setRecords(projectInfoBos));
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody ProjectInfoForm projectInfoForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{name}")
    public Result info(@PathVariable("name") String name){

        ProjectInfo projectInfo = projectInfoService.getById(name);

        return success(projectInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody ProjectInfoForm projectInfoForm){

        ProjectInfo projectInfo = new ProjectInfo();
        //Form --> domain
        BeanUtils.copyProperties(projectInfoForm,projectInfo);

        projectInfoService.save(projectInfo);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody ProjectInfo projectInfo){

        projectInfoService.updateById(projectInfo);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{name}")
    public Result delete(@PathVariable("name") String name){

        projectInfoService.removeById(name);

        return success();
    }

}
