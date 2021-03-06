package com.blackey.invest.rest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.common.rest.BaseRest;
import com.blackey.invest.dto.bo.DiagProjecinfoBo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.invest.component.domain.DiagProjecinfo;
import com.blackey.invest.dto.form.DiagProjecinfoForm;
import com.blackey.invest.component.service.DiagProjecinfoService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 项目信息表 API REST
 *
 * @author kaven
 * @date 2018-11-05 10:02:16
 */
@RestController
@RequestMapping("/invest/project")
public class DiagProjecinfoRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiagProjecinfoRest.class);

    @Autowired
    private DiagProjecinfoService diagProjecinfoService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("invest:projectinfo:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = diagProjecinfoService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    @RequiresPermissions("invest:projectinfo:list")
    public Result list(@RequestBody DiagProjecinfoForm diagProjecinfoForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("invest:projectinfo:info")
    public Result info(@PathVariable("id") Long id){

        DiagProjecinfo diagProjecinfo = diagProjecinfoService.getById(id);

        Page page = new Page(1,10);
        List<DiagProjecinfoBo> projectsPage = diagProjecinfoService.getProjectsPage("001",page);

        page.setRecords(projectsPage);



        System.out.println(success(page).toString());

        return success(diagProjecinfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("invest:projectinfo:save")
    public Result save(@RequestBody DiagProjecinfoForm diagProjecinfoForm){

        DiagProjecinfo diagProjecinfo = new DiagProjecinfo();
        //Form --> domain
        BeanUtils.copyProperties(diagProjecinfoForm,diagProjecinfo);

        diagProjecinfoService.save(diagProjecinfo);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("invest:projectinfo:update")
    public Result update(@RequestBody DiagProjecinfo diagProjecinfo){

        diagProjecinfoService.updateById(diagProjecinfo);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{id}")
    @RequiresPermissions("invest:projectinfo:delete")
    public Result delete(@PathVariable("id") Long id){

        diagProjecinfoService.removeById(id);

        return success();
    }

}
