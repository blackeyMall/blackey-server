package com.blackey.finance.component.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.finance.component.domain.UserRequireFollow;
import com.blackey.finance.dto.bo.RequirementInfoBo;
import com.blackey.finance.dto.bo.UserRequireFollowBo;
import com.blackey.finance.dto.form.AddOrCancelFollowForm;
import com.blackey.finance.dto.form.RequirementInfoForm;
import com.blackey.finance.dto.form.UserRequireFollowForm;
import com.blackey.finance.global.constants.AddCancelEnum;
import com.blackey.mybatis.service.BaseService;

import java.util.List;

/**
 * 用户需求关注表 UserRequireFollowService
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
public interface UserRequireFollowService extends BaseService<UserRequireFollow> {

    /**
     * 分页查询
     * @param form
     * @param page
     * @return
     */
    List<RequirementInfoBo> queryPage(RequirementInfoForm form, Page<RequirementInfoBo> page);

    /**
     * 取消或关注需求
     * @param form
     * @return
     */
    AddCancelEnum addFollowNum(AddOrCancelFollowForm form);

    /**
     * 通过requireId 删除对应关注信息
     * @param requireId
     */
    void deleteFollowByRequireId(String requireId);
}

