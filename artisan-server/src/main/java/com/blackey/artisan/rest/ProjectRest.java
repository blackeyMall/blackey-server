package com.blackey.artisan.rest;

import com.blackey.artisan.component.service.FileUploadService;
import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.artisan.component.domain.Project;
import com.blackey.artisan.dto.form.ProjectForm;
import com.blackey.artisan.component.service.ProjectService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 *  API REST
 *
 * @author kavenW
 * @date 2018-11-04 21:12:24
 */
@RestController
@RequestMapping("/artisan/project")
public class ProjectRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectRest.class);

    @Autowired
    private ProjectService projectService;

    @Resource
    FileUploadService fileUploadService;

    @Resource
    HttpServletRequest request;

    /**
    * 分页列表
    */
    @RequestMapping("/list/page")
    @RequiresPermissions("artisan:project:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = projectService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestBody ProjectForm projectForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){

        Project project = projectService.getById(id);

        return success(project);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody ProjectForm projectForm,@RequestParam MultipartFile file){
        if ((file != null) && !file.isEmpty()) {
            projectForm.setPicUrl(fileUploadService.uploadFile(request,file));
        }
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
        projectService.updateById(project);
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @RequestMapping("/delete/{id}")
    public Result delete(@PathVariable("id") String id){

        projectService.removeById(id);

        return success();
    }

}
