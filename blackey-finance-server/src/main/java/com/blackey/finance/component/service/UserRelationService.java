package com.blackey.finance.component.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.common.result.Result;
import com.blackey.finance.component.domain.UserRelation;
import com.blackey.finance.dto.form.UserRelationForm;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 用户好友关联表 UserRelationService
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
public interface UserRelationService extends BaseService<UserRelation> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 通过参数查询
     * @return
     */
    Page queryPageByOpenId(UserRelationForm form, Page page);

    /**
     * 添加好友
     * @param userRelationForm
     * @return
     */
    Result addFriend(UserRelationForm userRelationForm);


    /**
     * 通过id 和好友id 更新关系
     * @param userRelationForm
     */
    void updateByFriend(UserRelationForm userRelationForm);

    /**
     * 通过参数查询
     * @return
     */
    Page queryApplyPageByOpenId(UserRelationForm form, Page page);

    /**
     * 查询好友间的关系
     * @param form
     * @return
     */
    UserRelation findRelation(UserRelationForm form);

    /**
     * 删除好友
     * @param userRelationForm
     * @return
     */
    void fakeDelete(UserRelationForm userRelationForm);
}

