package com.blackey.artisan.rest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.artisan.component.domain.NotifyRecord;
import com.blackey.artisan.dto.form.NotifyRecordForm;
import com.blackey.artisan.component.service.NotifyRecordService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 *  API REST
 *
 * @author kaven
 * @date 2019-01-02 13:47:16
 */
@RestController
@RequestMapping("/artisan/notifyrecord")
public class NotifyRecordRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotifyRecordRest.class);

    @Autowired
    private NotifyRecordService notifyRecordService;


    /**
    * 分页列表
    */
    @GetMapping("/list/page")
    public Result list(String openId,Page page){
        return success(notifyRecordService.queryByOpenid(openId,page));
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody NotifyRecordForm notifyRecordForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{notifyContent}")
    public Result info(@PathVariable("notifyContent") String notifyContent){

        NotifyRecord notifyRecord = notifyRecordService.getById(notifyContent);

        return success(notifyRecord);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody NotifyRecordForm notifyRecordForm){

        NotifyRecord notifyRecord = new NotifyRecord();
        //Form --> domain
        BeanUtils.copyProperties(notifyRecordForm,notifyRecord);

        notifyRecordService.save(notifyRecord);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody NotifyRecord notifyRecord){

        notifyRecordService.updateById(notifyRecord);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{notifyContent}")
    public Result delete(@PathVariable("notifyContent") String notifyContent){

        notifyRecordService.removeById(notifyContent);

        return success();
    }

}
