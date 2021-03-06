package com.blackey.finance.component.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.common.exception.BusinessException;
import com.blackey.common.result.ResultCodeEnum;
import com.blackey.finance.component.domain.*;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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

        if(CollectionUtils.isEmpty(requirementInfoBos)){
            return null;
        }
        for (RequirementInfoBo requirementInfoBo : requirementInfoBos){
            List<String> imageInfos = imageInfoService.queryImagesUrl(requirementInfoBo.getId(),ObjectTypeEnum.REQUIRE.getValue());
            if(!CollectionUtils.isEmpty(imageInfos)){
                String[] images = new String[imageInfos.size()];
                imageInfos.toArray(images);
                requirementInfoBo.setImages(images);

            }
        }
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
        String requireId;
        for (RequirementInfoBo requirementInfoBo : requirementInfoBos){
            requireId = requirementInfoBo.getId();
            List<UserRequireFollow> userProjectFollows = userRequireFollowService.list(new QueryWrapper<UserRequireFollow>().eq("open_id", openId)
                    .eq("require_id", requireId));
            if(!CollectionUtils.isEmpty(userProjectFollows)){
                //已关注
                requirementInfoBo.setIsFollow(AddCancelEnum.ADD);
            }

            List<UserRequireLike> userProjectLikes = userRequireLikeService.list(new QueryWrapper<UserRequireLike>().eq("open_id", openId)
                    .eq("require_id", requireId));
            if(!CollectionUtils.isEmpty(userProjectLikes)){
                //已点赞
                requirementInfoBo.setIsLike(AddCancelEnum.ADD);
            }
            List<String> imageInfos = imageInfoService.queryImagesUrl(requireId,ObjectTypeEnum.REQUIRE.getValue());
            if(!CollectionUtils.isEmpty(imageInfos)){
                String[] images = new String[imageInfos.size()];
                imageInfos.toArray(images);
                requirementInfoBo.setImages(images);

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
    public String createRequirement(RequirementInfoForm form) {
        RequirementInfo requirementInfo = new RequirementInfo();
        //Form --> domain
        BeanUtils.copyProperties(form,requirementInfo);
        requirementInfo.setAuditStatus(AuditStatusEnum.SUCCESS);
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
        auditDetail.setAuditStatus(AuditStatusEnum.SUCCESS);
        auditDetailService.save(auditDetail);
        return requirementInfo.getId();
    }

    /**
     * 编辑需求
     *
     * @param form
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String editRequirement(RequirementInfoForm form) {
        RequirementInfo requirementInfo = new RequirementInfo();
        //Form --> domain
        BeanUtils.copyProperties(form,requirementInfo);
        baseMapper.updateById(requirementInfo);
        //删除图片
        imageInfoService.remove(new UpdateWrapper<ImageInfo>().eq("object_id",form.getId()));
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
        return requirementInfo.getId();
    }

    /**
     * 通过需求id查询详情信息
     *
     * @param id
     * @return
     */
    @Override
    public RequirementInfoBo queryDetailById(String id) {

        RequirementInfoBo requirementInfoBo = baseMapper.queryDetailById(id);

        /**
         * 关联图片
         */
        List<String> imagesUrls = imageInfoService.queryImagesUrl(requirementInfoBo.getId(), ObjectTypeEnum.REQUIRE.getValue());
        String[] strings = new String[imagesUrls.size()];
        requirementInfoBo.setImages(imagesUrls.toArray(strings));

        return requirementInfoBo;
    }

    /**
     * 删除需求信息
     *
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delRequireById(String id) {
        baseMapper.deleteById(id);
        //删除关注和点赞
        userRequireFollowService.deleteFollowByRequireId(id);
        userRequireLikeService.deleteLikeByRequireId(id);
        //删除需求的图片
        imageInfoService.deleteImagesByObjectId(id,ObjectTypeEnum.REQUIRE.getValue());

    }
}
