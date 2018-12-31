package com.blackey.tenant.rest;

import com.blackey.common.result.Result;
import com.blackey.common.result.ResultCodeEnum;
import com.blackey.tenant.component.domain.SysDict;
import com.blackey.tenant.component.service.SysDictService;
import com.blackey.tenant.dto.form.SysDictForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 数据字典表 API REST
 *
 * @author kavenW
 * @date 2018-06-29 14:18:32
 */
@RestController
@RequestMapping("/sys/dict")
public class SysDictRest extends AbstractController{

    private static final Logger LOGGER = LoggerFactory.getLogger(SysDictRest.class);

    @Autowired
    private SysDictService sysDictService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestBody SysDictForm sysDictForm){
        //TODO
        return new Result(ResultCodeEnum.SUCCESS,null);
    }


    /**
     * 查看详情信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Long id){

        SysDict sysDict = sysDictService.getById(id);

        return new Result(ResultCodeEnum.SUCCESS,sysDict);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody SysDictForm sysDictForm){

        SysDict sysDict = new SysDict();
        //Form --> domain
        BeanUtils.copyProperties(sysDictForm,sysDict);

        sysDictService.save(sysDict);

        return new Result(ResultCodeEnum.SUCCESS);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody SysDict sysDict){

        sysDictService.saveOrUpdate(sysDict);//全部更新
        
        return new Result(ResultCodeEnum.SUCCESS);
    }

    /**
     * 根据主键id删除
     */
    @RequestMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Long id){

        sysDictService.removeById(id);

        return new Result(ResultCodeEnum.SUCCESS);
    }

}
