package com.blackey.finance.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.finance.component.domain.Project;
import com.blackey.finance.dto.form.ProjectForm;
import com.blackey.finance.component.service.ProjectService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 项目信息表 API REST
 *
 * @author kaven
 * @date 2018-11-20 23:27:02
 */
@RestController
@RequestMapping("/finance/project")
public class ProjectRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectRest.class);

    @Autowired
    private ProjectService projectService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("finance:project:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = projectService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody ProjectForm projectForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){

        Project project = projectService.getById(id);

        return success(project);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody ProjectForm projectForm){

        Project project = new Project();
        //Form --> domain
        BeanUtils.copyProperties(projectForm,project);

        projectService.save(project);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody Project project){

        projectService.updateById(project);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable("id") String id){

        projectService.removeById(id);

        return success();
    }

}
