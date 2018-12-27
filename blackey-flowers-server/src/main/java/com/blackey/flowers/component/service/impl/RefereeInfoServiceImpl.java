package com.blackey.flowers.component.service.impl;

import com.blackey.flowers.component.domain.OrderInfo;
import com.blackey.flowers.component.service.OrderInfoService;
import com.blackey.flowers.dto.bo.RefereeInfoBo;
import com.blackey.flowers.dto.form.RefereeInfoForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;

import com.blackey.flowers.component.mapper.RefereeInfoMapper;
import com.blackey.flowers.component.domain.RefereeInfo;
import com.blackey.flowers.component.service.RefereeInfoService;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 *  RefereeInfoServiceImpl
 *
 * @author kaven
 * @date 2018-11-28 20:43:34
 */
@Service
public class RefereeInfoServiceImpl extends BaseServiceImpl<RefereeInfoMapper, RefereeInfo> implements RefereeInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefereeInfoServiceImpl.class);


    @Autowired
    OrderInfoService orderInfoService;

    /**
     * 分页查询
     *
     * @param refereeInfoForm
     * @param page
     * @return
     */
    @Override
    public List<RefereeInfoBo> queryPage(RefereeInfoForm refereeInfoForm, Page<RefereeInfoBo> page) {

        List<RefereeInfoBo> refereeInfoBos= baseMapper.queryPage(refereeInfoForm,page);

        //推荐人完成的订单数量
        if(!CollectionUtils.isEmpty(refereeInfoBos)){
            for (RefereeInfoBo bo: refereeInfoBos) {

                int count = orderInfoService.count(new QueryWrapper<OrderInfo>().eq("referee_id", bo.getId())
                        .eq("trade_status", "DONE"));
                bo.setOrderNum(count);

            }
        }

        return refereeInfoBos;
    }
}
