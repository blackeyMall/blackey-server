package com.blackey.finance.component.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.common.exception.BusinessException;
import com.blackey.common.result.ResultCodeEnum;
import com.blackey.finance.component.domain.*;
import com.blackey.finance.component.mapper.ProjectInfoMapper;
import com.blackey.finance.component.service.*;
import com.blackey.finance.dto.bo.ProjectInfoBo;
import com.blackey.finance.dto.form.ProjectBpForm;
import com.blackey.finance.dto.form.ProjectInfoForm;
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
 * 项目信息表 ProjectInfoServiceImpl
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Service
public class ProjectInfoServiceImpl extends BaseServiceImpl<ProjectInfoMapper, ProjectInfo> implements ProjectInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectInfoServiceImpl.class);

    @Autowired
    UserProjectFollowService userProjectFollowService;

    @Autowired
    UserProjectLikeService userProjectLikeService;
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
    public List<ProjectInfoBo> queryPage(ProjectInfoForm form, Page<ProjectInfoBo> page) {

        return baseMapper.queryPage(form,page);
    }

    /**
     * 增加或减少关注数量
     *
     * @param objectId
     * @param addCancelEnum
     * @return
     */
    @Override
    public boolean addFollowNum(String objectId, AddCancelEnum addCancelEnum) {

        ProjectInfo projectInfo = this.getById(objectId);
        if(projectInfo == null){
            throw new BusinessException(ResultCodeEnum.NOT_FOUND);
        }
        if(AddCancelEnum.ADD == addCancelEnum){
            projectInfo.setFollowNum(projectInfo.getFollowNum() + 1);
        }else {
            projectInfo.setFollowNum(projectInfo.getFollowNum() - 1);
        }
        return this.updateById(projectInfo);

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
        ProjectInfo projectInfo = this.getById(objectId);
        if(projectInfo == null){
            throw new BusinessException(ResultCodeEnum.NOT_FOUND);
        }
        if(AddCancelEnum.ADD == addCancelEnum){
            projectInfo.setLikeNum(projectInfo.getLikeNum() + 1);
        }else {
            projectInfo.setLikeNum(projectInfo.getLikeNum() - 1);
        }
        return this.updateById(projectInfo);
    }

    /**
     * 分页查询--所有项目
     *
     * @param form
     * @param page
     * @return
     */
    @Override
    public List<ProjectInfoBo> listAllPage(ProjectInfoForm form, Page<ProjectInfoBo> page) {

        List<ProjectInfoBo> projectInfoBos = baseMapper.listAllPage(form, page);
        if(CollectionUtils.isEmpty(projectInfoBos)){
            return null;
        }
        String openId = form.getOpenId();
        String projectId;
        for (ProjectInfoBo projectInfoBo : projectInfoBos){
            projectId = projectInfoBo.getId();
            List<UserProjectFollow> userProjectFollows = userProjectFollowService.list(new QueryWrapper<UserProjectFollow>().eq("open_id", openId)
                    .eq("project_id", projectId));
            if(!CollectionUtils.isEmpty(userProjectFollows)){
                //已关注
                projectInfoBo.setIsFollow(AddCancelEnum.ADD);
            }

            List<UserProjectLike> userProjectLikes = userProjectLikeService.list(new QueryWrapper<UserProjectLike>().eq("open_id", openId)
                    .eq("project_id", projectId));
            if(!CollectionUtils.isEmpty(userProjectLikes)){
                //已点赞
                projectInfoBo.setIsLike(AddCancelEnum.ADD);
            }

        }
        return projectInfoBos;
    }

    /**
     * 创建项目
     *
     * @param projectInfoForm
     */
    @Override
    public String createProject(ProjectInfoForm projectInfoForm) {
        ProjectInfo projectInfo = new ProjectInfo();
        //Form --> domain
        BeanUtils.copyProperties(projectInfoForm,projectInfo);
        projectInfo.setAuditStatus(AuditStatusEnum.SUCCESS);
        this.save(projectInfo);
        //保存需求图片
        if(projectInfoForm.getImages() != null && projectInfoForm.getImages().length > 0){
            for(String imageUrl : projectInfoForm.getImages()){
                ImageInfo imageInfo = new ImageInfo();
                imageInfo.setObjectId(projectInfo.getId());
                imageInfo.setImageUrl(imageUrl);
                imageInfo.setImageType(ObjectTypeEnum.REQUIRE.getValue());
                imageInfoService.save(imageInfo);
            }

        }
        //待审批记录
        AuditDetail auditDetail = new AuditDetail();
        auditDetail.setObjectId(projectInfo.getId());
        auditDetail.setObjectType(ObjectTypeEnum.PROJECT);
        auditDetail.setAuditStatus(AuditStatusEnum.SUCCESS);
        auditDetailService.save(auditDetail);

        return projectInfo.getId();
    }

    /**
     * 编辑项目
     *
     * @param projectInfoForm
     */
    @Override
    public String editProject(ProjectInfoForm projectInfoForm) {
        ProjectInfo projectInfo = new ProjectInfo();
        //Form --> domain
        BeanUtils.copyProperties(projectInfoForm,projectInfo);
        this.updateById(projectInfo);

        //删除原来图片，保存需求图片,
        imageInfoService.remove(new UpdateWrapper<ImageInfo>().eq("object_id",projectInfoForm.getId()));
        if(projectInfoForm.getImages() != null && projectInfoForm.getImages().length > 0){
            for(String imageUrl : projectInfoForm.getImages()){
                ImageInfo imageInfo = new ImageInfo();
                imageInfo.setObjectId(projectInfo.getId());
                imageInfo.setImageUrl(imageUrl);
                imageInfo.setImageType(ObjectTypeEnum.REQUIRE.getValue());
                imageInfoService.save(imageInfo);
            }

        }
        return projectInfo.getId();
    }

    /**
     * 更新bp附近信息
     *
     * @param form
     */
    @Override
    public void updateBpInfo(ProjectBpForm form) {
        ProjectInfo projectInfo = baseMapper.selectById(form.getProjedtId());
        if(null == projectInfo){
            throw new BusinessException(ResultCodeEnum.NOT_FOUND);
        }
        projectInfo.setAttachment(form.getAttachment());
        baseMapper.updateById(projectInfo);
    }

    /**
     * 项目详情
     *
     * @param id
     * @return
     */
    @Override
    public ProjectInfoBo queryProjectDetail(String id,String openId) {

        ProjectInfoBo projectInfoBo = baseMapper.queryProjectDetail(id);

        /**
         * 关联图片
         */
        List<String> imagesUrls = imageInfoService.queryImagesUrl(projectInfoBo.getId(), ObjectTypeEnum.PROJECT.getValue());
        String[] strings = new String[imagesUrls.size()];
        projectInfoBo.setImages(imagesUrls.toArray(strings));
        /**
         * 判断是否关注
         */
        List<UserProjectFollow> userProjectFollows = userProjectFollowService.list(new QueryWrapper<UserProjectFollow>()
                .eq("project_id", id).eq("open_id", openId));
        if(CollectionUtils.isEmpty(userProjectFollows)){
            projectInfoBo.setIsFollow(AddCancelEnum.CANCEL);
        }else {
            projectInfoBo.setIsFollow(AddCancelEnum.ADD);
        }
        return projectInfoBo;
    }

    /**
     * 根据项目id查看项目详情
     *
     * @param id
     * @return
     */
    @Override
    public ProjectInfoBo projectDetailById(String id) {
        ProjectInfoBo projectInfoBo = baseMapper.queryProjectDetail(id);
        return projectInfoBo;
    }

    /**
     * 删除项目信息
     *
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteProjectById(String id) {
        baseMapper.deleteById(id);
        //删除关注和点赞
        userProjectFollowService.deleteFollowByProjectId(id);
        userProjectLikeService.deleteLikeByProjectId(id);
        //删除需求的图片
        imageInfoService.deleteImagesByObjectId(id,ObjectTypeEnum.PROJECT.getValue());

    }
}
