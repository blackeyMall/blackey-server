package com.blackey.artisan.rest;

import com.blackey.artisan.component.service.OrderService;
import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.artisan.component.domain.Feedback;
import com.blackey.artisan.dto.form.FeedbackForm;
import com.blackey.artisan.component.service.FeedbackService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 *  API REST
 *
 * @author kavenW
 * @date 2018-11-05 11:01:32
 */
@RestController
@RequestMapping("/artisan/feedback")
public class FeedbackRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackRest.class);

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private OrderService orderService;

    /**
    * 分页列表
    */
    @RequestMapping("/list/page")
    @RequiresPermissions("artisan:feedback:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = feedbackService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestBody FeedbackForm feedbackForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){

        Feedback feedback = feedbackService.getById(id);

        return success(feedback);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody FeedbackForm feedbackForm){

        Feedback feedback = new Feedback();
        //Form --> domain
        BeanUtils.copyProperties(feedbackForm,feedback);
        feedbackService.save(feedback);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody Feedback feedback){

        feedbackService.updateById(feedback);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @RequestMapping("/delete/{id}")
    public Result delete(@PathVariable("id") String id){

        feedbackService.removeById(id);

        return success();
    }

}
