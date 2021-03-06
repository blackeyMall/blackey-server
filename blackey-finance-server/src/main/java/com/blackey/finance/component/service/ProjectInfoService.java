package com.blackey.finance.component.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.finance.component.domain.ProjectInfo;
import com.blackey.finance.dto.bo.ProjectInfoBo;
import com.blackey.finance.dto.form.ProjectBpForm;
import com.blackey.finance.dto.form.ProjectInfoForm;
import com.blackey.finance.global.constants.AddCancelEnum;
import com.blackey.mybatis.service.BaseService;

import java.util.List;

/**
 * 项目信息表 ProjectInfoService
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
public interface ProjectInfoService extends BaseService<ProjectInfo> {

    /**
     * 分页查询
     * @param form
     * @param page
     * @return
     */
    List<ProjectInfoBo> queryPage(ProjectInfoForm form, Page<ProjectInfoBo> page);

    /**
     * 增加或减少关注数量
     * @param objectId
     * @param addCancelEnum
     * @return
     */
    boolean addFollowNum(String objectId, AddCancelEnum addCancelEnum);

    /**
     * 增加或减少点赞数量
     * @param objectId
     * @param addCancelEnum
     * @return
     */
    boolean addLikeNum(String objectId, AddCancelEnum addCancelEnum);
    /**
     * 分页查询--所有项目
     * @param form
     * @param page
     * @return
     */
    List<ProjectInfoBo> listAllPage(ProjectInfoForm form, Page<ProjectInfoBo> page);

    /**
     * 创建项目
     * @param projectInfoForm
     */
    String createProject(ProjectInfoForm projectInfoForm);

    /**
     * 创建项目
     * @param projectInfoForm
     */
    String editProject(ProjectInfoForm projectInfoForm);


    /**
     * 更新bp附近信息
     * @param form
     */
    void updateBpInfo(ProjectBpForm form);

    /**
     * 项目详情-更加项目ID和用户openID
     * @param id
     * @param openId
     * @return
     */
    ProjectInfoBo queryProjectDetail(String id,String openId);

    /**
     * 根据项目id查看项目详情
     * @param id
     * @return
     */
    ProjectInfoBo projectDetailById(String id);

    /**
     * 删除项目信息
     * @param id
     */
    void deleteProjectById(String id);
}

