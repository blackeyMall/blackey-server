package com.blackey.finance.rest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.common.rest.BaseRest;
import com.blackey.common.result.Result;
import com.blackey.finance.component.domain.ProjectInfo;
import com.blackey.finance.component.service.ProjectInfoService;
import com.blackey.finance.component.service.UserProjectFollowService;
import com.blackey.finance.dto.bo.ProjectInfoBo;
import com.blackey.finance.dto.form.ProjectBpForm;
import com.blackey.finance.dto.form.ProjectInfoForm;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目信息表 API REST
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@RestController
@RequestMapping("/finance/project")
public class ProjectInfoRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectInfoRest.class);

    @Autowired
    private ProjectInfoService projectInfoService;
    @Autowired
    UserProjectFollowService userProjectFollowService;


    /**
    * 分页列表--我的项目
    */
    @PostMapping("/list/page")
    @RequiresPermissions("finance:projectinfo:list")
    public Result listPage(@RequestBody ProjectInfoForm form){

        Page<ProjectInfoBo> page = new Page<>(form.getCurrent(),form.getSize());

        List<ProjectInfoBo> projectInfoBos = projectInfoService.queryPage(form,page);

        return success(page.setRecords(projectInfoBos));
    }

    /**
     * 列表--所有项目
     * 标记已关注和已点赞
     */
    @PostMapping("/list")
    public Result listAllPage(@RequestBody ProjectInfoForm form){
        Page<ProjectInfoBo> page = new Page<>(form.getCurrent(),form.getSize());
        List<ProjectInfoBo> projectInfoBos ;

        switch (form.getTableCode().getValue()){
            case "DEFAULT":
                projectInfoBos = projectInfoService.listAllPage(form,page);
                break;
            case "RECOMMEND":
                form.setIsRecommend("1");
                projectInfoBos = projectInfoService.listAllPage(form,page);
                break;
            case "MY_CREATE":
                projectInfoBos = projectInfoService.queryPage(form,page);
                break;
            case "MY_FOLLOW":
                projectInfoBos = userProjectFollowService.queryPage(form,page);
                break;
            default:
                projectInfoBos = projectInfoService.listAllPage(form,page);
                break;

        }

        return success(page.setRecords(projectInfoBos));
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){

        ProjectInfo projectInfo = projectInfoService.getById(id);

        return success(projectInfo);
    }

    /**
     * 保存--项目创建
     */
    @PostMapping("/save")
    public Result save(@RequestBody ProjectInfoForm projectInfoForm){

        projectInfoService.createProject(projectInfoForm);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody ProjectInfoForm form){

        ProjectInfo projectInfo = new ProjectInfo();
        //Form --> domain
        BeanUtils.copyProperties(form,projectInfo);


        projectInfoService.updateById(projectInfo);

        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable("id") String id){

        projectInfoService.removeById(id);

        return success();
    }

    /**
     * 上传bp回调方法-bp信息
     */
    @PostMapping("/bp/update")
    public Result updateBpInfo(@RequestBody ProjectBpForm form){

        projectInfoService.updateBpInfo(form);

        return success();
    }

}
