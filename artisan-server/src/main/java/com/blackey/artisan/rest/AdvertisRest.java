package com.blackey.artisan.rest;

import com.blackey.artisan.component.domain.Advertis;
import com.blackey.artisan.component.service.AdvertisService;
import com.blackey.artisan.dto.form.AdvertisForm;
import com.blackey.common.rest.BaseRest;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

/**
 * API REST
 *
 * @author kavenW
 * @date 2018-11-07 09:50:15
 */
@RestController
@RequestMapping("/artisan/advertis")
public class AdvertisRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdvertisRest.class);

    @Autowired
    private AdvertisService advertisService;

    @Resource
    HttpServletRequest request;

    /**
     * 分页列表
     */
    @RequestMapping("/list/page")
    @RequiresPermissions("artisan:advertis:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = advertisService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestBody AdvertisForm advertisForm) {
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") String id) {

        Advertis advertis = advertisService.getById(id);

        return success(advertis);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody AdvertisForm advertisForm) {

        Advertis advertis = new Advertis();
        //Form --> domain
        BeanUtils.copyProperties(advertisForm, advertis);

        advertisService.save(advertis);
        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody Advertis advertis) {

        advertisService.updateById(advertis);//全部更新

        return success();
    }

    /**
     * 根据主键id删除
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody String[] ids) {

        advertisService.removeByIds(Arrays.asList(ids));

        return success();
    }

}
