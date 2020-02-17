package com.blackey.bbs.web;

import com.blackey.common.rest.BaseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.bbs.component.domain.UserGradeInfo;
import com.blackey.bbs.component.service.UserGradeInfoService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 会员等级信息表 API REST
 *
 * @author kaven
 * @date 2020-02-16 18:51:35
 */
@RestController
@RequestMapping("/bbs/usergradeinfo")
public class UserGradeInfoRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserGradeInfoRest.class);

    @Autowired
    private UserGradeInfoService userGradeInfoService;


    /**
    * 分页列表
    */
    @PostMapping("/list/page")
    @RequiresPermissions("bbs:usergradeinfo:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = userGradeInfoService.queryPage(params);

        return success(page);
    }

    /**
     * 列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody UserGradeInfo userGradeInfoForm){
        //TODO
        return success();
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{gradeName}")
    public Result info(@PathVariable("gradeName") String gradeName){

        UserGradeInfo userGradeInfo = userGradeInfoService.getById(gradeName);

        return success(userGradeInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody UserGradeInfo userGradeInfoForm){

        UserGradeInfo userGradeInfo = new UserGradeInfo();
        //Form --> domain
        BeanUtils.copyProperties(userGradeInfoForm,userGradeInfo);

        userGradeInfoService.save(userGradeInfo);

        return success();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody UserGradeInfo userGradeInfo){

        userGradeInfoService.updateById(userGradeInfo);//全部更新
        
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{gradeName}")
    public Result delete(@PathVariable("gradeName") String gradeName){

        userGradeInfoService.removeById(gradeName);

        return success();
    }

}
