package com.blackey.invest.rest;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.invest.component.domain.DiagBpFile;
import com.blackey.invest.dto.form.DiagBpFileForm;
import com.blackey.invest.component.service.DiagBpFileService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 上传bp文件信息 API REST
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@RestController
@RequestMapping("/invest/diagbpfile")
public class DiagBpFileRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiagBpFileRest.class);

    @Autowired
    private DiagBpFileService diagBpFileService;


    /**
    * 分页列表
    */
    @RequestMapping("/list/page")
    @RequiresPermissions("invest:diagbpfile:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = diagBpFileService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestBody DiagBpFileForm diagBpFileForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") Long id){

        DiagBpFile diagBpFile = diagBpFileService.getById(id);

        return success(diagBpFile);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody DiagBpFileForm diagBpFileForm){

        DiagBpFile diagBpFile = new DiagBpFile();
        //Form --> domain
        BeanUtils.copyProperties(diagBpFileForm,diagBpFile);

        diagBpFileService.save(diagBpFile);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody DiagBpFile diagBpFile){

        diagBpFileService.updateById(diagBpFile);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @RequestMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Long id){

        diagBpFileService.removeById(id);

        return success();
    }

}
