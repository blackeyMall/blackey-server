package com.blackey.finance.rest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.common.rest.BaseRest;
import com.blackey.finance.component.service.UserRequireFollowService;
import com.blackey.finance.dto.bo.RequirementInfoBo;
import com.blackey.finance.global.constants.AuditStatusEnum;
import com.blackey.finance.global.constants.TableCodeEnum;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blackey.finance.component.domain.RequirementInfo;
import com.blackey.finance.dto.form.RequirementInfoForm;
import com.blackey.finance.component.service.RequirementInfoService;
import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 需求信息表 API REST
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@RestController
@RequestMapping("/finance/requirement")
public class RequirementInfoRest extends BaseRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequirementInfoRest.class);

    @Autowired
    private RequirementInfoService requirementInfoService;

    @Autowired
    private UserRequireFollowService userRequireFollowService;


    /**
    * 分页列表--我的需求
    */
    @PostMapping("/list/page")
    @RequiresPermissions("finance:requirement:list")
    public Result listPage(@RequestBody RequirementInfoForm form){

        Page<RequirementInfoBo> page = new Page<>(form.getCurrent(),form.getSize());

        List<RequirementInfoBo> requirementInfoBos = requirementInfoService.queryPage(form,page);

        return success(page.setRecords(requirementInfoBos));
    }

    /**
     * 列表--所有需求
     * 标记已关注和已点赞
     */
    @PostMapping("/list")
    public Result listAllPage(@RequestBody RequirementInfoForm form){
        Page<RequirementInfoBo> page = new Page<>(form.getCurrent(),form.getSize());

        List<RequirementInfoBo> requirementInfoBos;
        switch (form.getTableCode().getValue()){
            case "DEFAULT":
                requirementInfoBos = requirementInfoService.listAllPage(form,page);
                break;
            case "TODAY_PUBLISH":
                form.setIsTodayPublish(1);
                requirementInfoBos = requirementInfoService.listAllPage(form,page);
                break;
            case "MY_CREATE":
                requirementInfoBos = requirementInfoService.queryPage(form,page);
                break;
            case "MY_FOLLOW":
                requirementInfoBos = userRequireFollowService.queryPage(form,page);
                break;
             default:
                 requirementInfoBos = requirementInfoService.listAllPage(form,page);
                 break;

        }

        return success(page.setRecords(requirementInfoBos));
    }


    /**
     * 查看详情信息
     */
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){

        RequirementInfoBo requirementInfoBo = requirementInfoService.queryDetailById(id);

        return success(requirementInfoBo);
    }

    /**
     * 保存/编辑--创建需求信息
     */
    @PostMapping("/save")
    public Result save(@RequestBody RequirementInfoForm requirementInfoForm){

        String requireId;
        if(StringUtils.isNotBlank(requirementInfoForm.getId())){
            requireId = requirementInfoService.editRequirement(requirementInfoForm);
        }else {
            requireId = requirementInfoService.createRequirement(requirementInfoForm);
        }
        return success(requireId);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody RequirementInfoForm requirementInfoForm){
        RequirementInfo requirementInfo = new RequirementInfo();
        //Form --> domain
        BeanUtils.copyProperties(requirementInfoForm,requirementInfo);
        requirementInfoService.updateById(requirementInfo);
        //全部更新
        return success();
    }

    /**
     * 根据主键id删除
     */
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable("id") String id){

        requirementInfoService.removeById(id);

        return success();
    }

}
