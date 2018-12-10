package com.blackey.finance.component.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.common.exception.BusinessException;
import com.blackey.common.result.ResultCodeEnum;
import com.blackey.finance.component.domain.RequirementInfo;
import com.blackey.finance.component.mapper.RequirementInfoMapper;
import com.blackey.finance.component.service.RequirementInfoService;
import com.blackey.finance.dto.bo.RequirementInfoBo;
import com.blackey.finance.dto.form.RequirementInfoForm;
import com.blackey.finance.global.constants.AddCancelEnum;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 需求信息表 RequirementInfoServiceImpl
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Service
public class RequirementInfoServiceImpl extends BaseServiceImpl<RequirementInfoMapper, RequirementInfo> implements RequirementInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequirementInfoServiceImpl.class);


    /**
     * 分页查询
     *
     * @param form
     * @param page
     * @return
     */
    @Override
    public List<RequirementInfoBo> queryPage(RequirementInfoForm form, Page<RequirementInfoBo> page) {

        List<RequirementInfoBo> requirementInfoBos = baseMapper.queryPage(form,page);

        return requirementInfoBos;
    }

    /**
     * 取消或关注需求数量增加
     * @param objectId
     * @param addCancelEnum
     * @return
     */
    @Override
    public boolean addFollowNum(String objectId, AddCancelEnum addCancelEnum) {
        RequirementInfo requirementInfo = this.getById(objectId);
        if(requirementInfo == null){
            throw new BusinessException(ResultCodeEnum.NOT_FOUND);
        }
        if(AddCancelEnum.ADD == addCancelEnum){
            requirementInfo.setFollowNum(requirementInfo.getFollowNum() + 1);
        }else {
            requirementInfo.setFollowNum(requirementInfo.getFollowNum() - 1);
        }
        return this.updateById(requirementInfo);
    }

    /**
     * 增加或减少点赞数量
     *
     * @param objectId
     * @param addCancelEnum
     * @return
     */
    @Override
    public boolean addLikeNum(String objectId, AddCancelEnum addCancelEnum) {
        RequirementInfo requirementInfo = this.getById(objectId);
        if(requirementInfo == null){
            throw new BusinessException(ResultCodeEnum.NOT_FOUND);
        }
        if(AddCancelEnum.ADD == addCancelEnum){
            requirementInfo.setLikeNum(requirementInfo.getLikeNum() + 1);
        }else {
            requirementInfo.setLikeNum(requirementInfo.getLikeNum() - 1);
        }
        return this.updateById(requirementInfo);
    }
}
