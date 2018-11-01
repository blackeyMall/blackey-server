package com.blackey.admin.rest;

import com.blackey.common.result.Result;
import com.blackey.common.result.ResultCodeEnum;
import com.blackey.admin.component.domain.SysRoleDept;
import com.blackey.admin.component.service.SysRoleDeptService;
import com.blackey.admin.dto.form.SysRoleDeptForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 角色与部门对应关系 API REST
 *
 * @author kavenW
 * @date 2018-06-29 14:18:32
 */
@RestController
@RequestMapping("/sys/roledept")
public class SysRoleDeptRest extends AbstractController{

    private static final Logger LOGGER = LoggerFactory.getLogger(SysRoleDeptRest.class);

    @Autowired
    private SysRoleDeptService sysRoleDeptService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestBody SysRoleDeptForm sysRoleDeptForm){
        //TODO
        return new Result(ResultCodeEnum.SUCCESS,null);
    }


    /**
     * 查看详情信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Long id){

        SysRoleDept sysRoleDept = sysRoleDeptService.getById(id);

        return new Result(ResultCodeEnum.SUCCESS,sysRoleDept);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody SysRoleDeptForm sysRoleDeptForm){

        SysRoleDept sysRoleDept = new SysRoleDept();
        //Form --> domain
        BeanUtils.copyProperties(sysRoleDeptForm,sysRoleDept);

        sysRoleDeptService.save(sysRoleDept);

        return new Result(ResultCodeEnum.SUCCESS);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody SysRoleDept sysRoleDept){

        sysRoleDeptService.updateById(sysRoleDept);//全部更新
        
        return new Result(ResultCodeEnum.SUCCESS);
    }

    /**
     * 根据主键id删除
     */
    @RequestMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Long id){

        sysRoleDeptService.removeById(id);

        return new Result(ResultCodeEnum.SUCCESS);
    }

}
