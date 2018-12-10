package com.blackey.finance.component.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.finance.component.domain.UserProjectFollow;
import com.blackey.finance.dto.bo.UserProjectFollowBo;
import com.blackey.finance.dto.form.AddOrCancelFollowForm;
import com.blackey.finance.dto.form.UserProjectFollowForm;
import com.blackey.finance.global.constants.AddCancelEnum;
import com.blackey.mybatis.service.BaseService;

import java.util.List;

/**
 * 用户关注项目表 UserProjectFollowService
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
public interface UserProjectFollowService extends BaseService<UserProjectFollow> {

    /**
     * 分页查询
     * @param form
     * @param page
     * @return
     */
    List<UserProjectFollowBo> queryPage(UserProjectFollowForm form, Page<UserProjectFollowBo> page);

    /**
     * 关注项目
     * @param addOrCancelFollowForm
     * @return
     */
    AddCancelEnum followProject(AddOrCancelFollowForm addOrCancelFollowForm);
}

