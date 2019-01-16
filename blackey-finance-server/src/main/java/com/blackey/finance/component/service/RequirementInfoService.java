package com.blackey.finance.component.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.finance.component.domain.RequirementInfo;
import com.blackey.finance.dto.bo.RequirementInfoBo;
import com.blackey.finance.dto.form.RequirementInfoForm;
import com.blackey.finance.global.constants.AddCancelEnum;
import com.blackey.mybatis.service.BaseService;

import java.util.List;

/**
 * 需求信息表 RequirementInfoService
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
public interface RequirementInfoService extends BaseService<RequirementInfo> {

    /**
     * 分页查询--我的需求
     * @param form
     * @param page
     * @return
     */
    List<RequirementInfoBo> queryPage(RequirementInfoForm form, Page<RequirementInfoBo> page);

    /**
     * 增加或减少关注数量
     * @param objectId
     * @param addCancelEnum
     * @return
     */
    boolean addFollowNum(String objectId, AddCancelEnum addCancelEnum);


    /**
     * 增加或减少点赞数量
     * @param objectId
     * @param addCancelEnum
     * @return
     */
    boolean addLikeNum(String objectId, AddCancelEnum addCancelEnum);

    /**
     * 分页查询--所有需求
     * @param form
     * @param page
     * @return
     */
    List<RequirementInfoBo> listAllPage(RequirementInfoForm form, Page<RequirementInfoBo> page);

    /**
     * 创建需求
     * @param form
     */
    String createRequirement(RequirementInfoForm form);

    /**
     * 编辑需求
     * @param form
     */
    String editRequirement(RequirementInfoForm form);


    /**
     * 通过需求id查询详情信息
     * @param id
     * @return
     */
    RequirementInfoBo queryDetailById(String id);
}

