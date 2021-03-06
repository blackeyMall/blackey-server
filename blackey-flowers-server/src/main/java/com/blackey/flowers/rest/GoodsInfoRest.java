package com.blackey.flowers.rest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.common.rest.BaseRest;
import com.blackey.flowers.dto.bo.GoodsInfoBo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.flowers.component.domain.GoodsInfo;
import com.blackey.flowers.dto.form.GoodsInfoForm;
import com.blackey.flowers.component.service.GoodsInfoService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 商品表 API REST
 *
 * @author kaven
 * @date 2018-11-20 23:49:38
 */
@RestController
@RequestMapping("/flowers/goods")
public class GoodsInfoRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsInfoRest.class);

    @Autowired
    private GoodsInfoService goodsInfoService;


    /**
    * 分页列表
    */
    @GetMapping("/list/page")
    @RequiresPermissions("flowers:goods:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsInfoService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    @RequiresPermissions("flowers:goods:list")
    public Result list(@RequestBody GoodsInfoForm goodsInfoForm){

        GoodsInfo goodsInfo = new GoodsInfo();
        BeanUtils.copyProperties(goodsInfoForm,goodsInfo);

        List<GoodsInfo> goodsInfos = goodsInfoService.list(new QueryWrapper<GoodsInfo>(goodsInfo));

        return success(goodsInfos);
    }

    /**
     * 小程序 分页列表
     */
    @PostMapping("/wechat/list/page")
    public Result getGoodsList(@RequestBody GoodsInfoForm goodsInfoForm){

        Page<GoodsInfoBo> page = new Page<>(goodsInfoForm.getCurrent(),goodsInfoForm.getSize());

        List<GoodsInfoBo> goodsInfos = goodsInfoService.getGoodsListPage(goodsInfoForm,page);
        return success(page.setRecords(goodsInfos));
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("flowers:goods:select")
    public Result info(@PathVariable("id") String id){

        GoodsInfo goodsInfo = goodsInfoService.getById(id);

        return success(goodsInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("flowers:goods:save")
    public Result save(@RequestBody GoodsInfoForm goodsInfoForm){

        GoodsInfo goodsInfo = new GoodsInfo();
        //Form --> domain
        BeanUtils.copyProperties(goodsInfoForm,goodsInfo);
        goodsInfo.setGoodsNo(UUID.randomUUID().toString().replace("-",""));
        goodsInfoService.save(goodsInfo);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("flowers:goods:update")
    public Result update(@RequestBody GoodsInfo goodsInfo){

        //全部更新
        goodsInfoService.updateById(goodsInfo);
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{id}")
    @RequiresPermissions("flowers:goods:delete")
    public Result delete(@PathVariable("id") String id){

        goodsInfoService.removeById(id);

        return success();
    }

}
