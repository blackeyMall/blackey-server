package com.blackey.finance.component.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.common.result.Result;
import com.blackey.finance.component.domain.UserPersonFollow;
import com.blackey.finance.dto.form.UserPersonFollowForm;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 用户关注用户表 UserPersonFollowService
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
public interface UserPersonFollowService extends BaseService<UserPersonFollow> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);


    /**
     * 通过openid 查询关注列表
     */
    PageUtils queryByOpenid(UserPersonFollowForm form,Page page);


    /**
     * 关注或取消关注
     */
    Result foucsOrCancel(UserPersonFollowForm form);
}

