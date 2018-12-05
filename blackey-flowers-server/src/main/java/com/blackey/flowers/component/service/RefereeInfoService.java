package com.blackey.flowers.component.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.flowers.dto.bo.RefereeInfoBo;
import com.blackey.flowers.dto.form.RefereeInfoForm;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.flowers.component.domain.RefereeInfo;

import java.util.List;
import java.util.Map;

/**
 *  RefereeInfoService
 *
 * @author kaven
 * @date 2018-11-28 20:43:34
 */
public interface RefereeInfoService extends BaseService<RefereeInfo> {

    /**
     * 分页查询
     * @param refereeInfoForm
     * @param page
     * @return
     */
    List<RefereeInfoBo> queryPage(RefereeInfoForm refereeInfoForm, Page<RefereeInfoBo> page);
}

