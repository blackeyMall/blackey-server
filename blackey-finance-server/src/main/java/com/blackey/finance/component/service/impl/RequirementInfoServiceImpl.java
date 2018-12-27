package com.blackey.finance.component.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.common.exception.BusinessException;
import com.blackey.common.result.ResultCodeEnum;
import com.blackey.finance.component.domain.*;
import com.blackey.finance.component.mapper.ImageInfoMapper;
import com.blackey.finance.component.mapper.RequirementInfoMapper;
import com.blackey.finance.component.service.*;
import com.blackey.finance.dto.bo.RequirementInfoBo;
import com.blackey.finance.dto.form.RequirementInfoForm;
import com.blackey.finance.global.constants.AddCancelEnum;
import com.blackey.finance.global.constants.AuditStatusEnum;
import com.blackey.finance.global.constants.ObjectTypeEnum;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.awt.*;
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

    @Autowired
    UserRequireFollowService userRequireFollowService;

    @Autowired
    UserRequireLikeService userRequireLikeService;

    @Autowired
    AuditDetailService auditDetailService;

    @Autowired
    ImageInfoService imageInfoService;

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

    /**
     * 分页查询--所有需求
     *
     * @param form
     * @param page
     * @return
     */
    @Override
    public List<RequirementInfoBo> listAllPage(RequirementInfoForm form, Page<RequirementInfoBo> page) {

        List<RequirementInfoBo> requirementInfoBos = baseMapper.listAllPage(form, page);

        if(CollectionUtils.isEmpty(requirementInfoBos)){
            return null;
        }
        String openId = form.getOpenId();
        String projectId;
        for (RequirementInfoBo requirementInfoBo : requirementInfoBos){
            projectId = requirementInfoBo.getId();
            List<UserRequireFollow> userProjectFollows = userRequireFollowService.list(new QueryWrapper<UserRequireFollow>().eq("open_id", openId)
                    .eq("require_id", projectId));
            if(!CollectionUtils.isEmpty(userProjectFollows)){
                //已关注
                requirementInfoBo.setIsFollow(AddCancelEnum.ADD);
            }

            List<UserRequireLike> userProjectLikes = userRequireLikeService.list(new QueryWrapper<UserRequireLike>().eq("open_id", openId)
                    .eq("require_id", projectId));
            if(!CollectionUtils.isEmpty(userProjectLikes)){
                //已点赞
                requirementInfoBo.setIsLike(AddCancelEnum.ADD);
            }

        }

        return requirementInfoBos;
    }

    /**
     * 创建需求
     *
     * @param form
     */
    @Override
    public void createRequirement(RequirementInfoForm form) {
        RequirementInfo requirementInfo = new RequirementInfo();
        //Form --> domain
        BeanUtils.copyProperties(form,requirementInfo);
        requirementInfo.setAuditStatus(AuditStatusEnum.WAITING);
        baseMapper.insert(requirementInfo);
        //保存需求图片
        if(form.getImages() != null && form.getImages().length > 0){
            for(String imageUrl : form.getImages()){
                ImageInfo imageInfo = new ImageInfo();
                imageInfo.setObjectId(requirementInfo.getId());
                imageInfo.setImageUrl(imageUrl);
                imageInfo.setImageType(ObjectTypeEnum.REQUIRE.getValue());
                imageInfoService.save(imageInfo);
            }

        }
        //待审批记录
        AuditDetail auditDetail = new AuditDetail();
        auditDetail.setObjectId(requirementInfo.getId());
        auditDetail.setObjectType(ObjectTypeEnum.REQUIRE);
        auditDetail.setAuditStatus(AuditStatusEnum.WAITING);
        auditDetailService.save(auditDetail);
    }
}
