package com.blackey.finance.component.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.finance.component.domain.ProjectInfo;
import com.blackey.finance.dto.bo.ProjectInfoBo;
import com.blackey.finance.dto.form.ProjectInfoForm;
import com.blackey.mybatis.dao.BaseDAO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 项目信息表 ProjectInfoMapper
 * 
 * @author kaven
 * @date 2018-12-07 09:40:20
 */

public interface ProjectInfoMapper extends BaseDAO<ProjectInfo> {

    /**
     * 分页查询--我的项目
     * @param form
     * @param page
     * @return
     */
    @Select("<script>" +
            "SELECT p.*,u.name as userName,u.sex,u.company,u.duties,u.avatar_url FROM t_project_info p left join t_user_info u on p.open_id = u.open_id " +
            " WHERE p.is_deleted = 0  and u.is_deleted = 0 " +
            "<if test=\"form.openId != '' and form.openId != null\">" +
            " and p.open_id = #{form.openId}\n" +
            "</if>" +
            "<if test=\"form.name != null and form.name != '' \">" +
            " and p.name like concat(concat('%',#{form.name}),'%')\n" +
            "</if>" +
            "<if test=\"form.label != null and form.label != '' \">" +
            " and p.label like concat(concat('%',#{form.label}),'%')\n" +
            "</if>" +
            "<if test=\"form.orderbyEnum.value == 'FOLLOWNUM' \">\n" +
            " order by p.follow_num desc \n" +
            "</if>" +
            "<if test=\"form.orderbyEnum.value == 'LIKENUM' \">\n" +
            " order by p.like_num desc \n" +
            "</if>" +
            "<if test=\"form.orderbyEnum.value == 'DEFAULT' or form.orderbyEnum.value == '' \">\n" +
            " order by p.created_date desc \n" +
            "</if>" +
            "</script>")
    List<ProjectInfoBo> queryPage(@Param("form") ProjectInfoForm form, Page<ProjectInfoBo> page);

    /**
     * 分页查询 -- 所有项目信息
     * @param form
     * @param page
     * @return
     */
    @Select("<script>" +
            "SELECT p.*,u.name as userName,u.sex,u.company,u.duties,u.avatar_url FROM t_project_info p left join t_user_info u on p.open_id = u.open_id " +
            " where p.is_deleted = 0 and u.is_deleted = 0 " +
//            "<if test=\"form.openId != '' and form.openId != null\">" +
//            " and p.open_id != #{form.openId}\n" +
//            "</if>" +
            "<if test=\"form.category != null and form.category.value != 'DEFAULT'  \">" +
            " and p.category = #{form.category.value}\n" +
            "</if>" +
            "<if test=\"form.name != null and form.name != '' \">" +
            " and p.name like concat(concat('%',#{form.name}),'%')\n" +
            "</if>" +
            "<if test=\"form.label != null and form.label != '' \">" +
            " and p.label like concat(concat('%',#{form.label}),'%')\n" +
            "</if>" +
            "<if test=\"form.isRecommend != '' and form.isRecommend != null\">" +
            " and p.is_recommend != #{form.isRecommend}\n" +
            "</if>" +
            "<if test=\"form.auditStatus != null and form.auditStatus.value != 'DEFAULT' \">" +
            " and p.audit_status = #{form.auditStatus.value}\n" +
            "</if>" +
            "<if test=\"form.orderbyEnum.value == 'FOLLOWNUM' \">\n" +
            " order by p.follow_num desc \n" +
            "</if>" +
            "<if test=\"form.orderbyEnum.value == 'LIKENUM' \">\n" +
            " order by p.like_num desc \n" +
            "</if>" +
            "<if test=\"form.orderbyEnum.value == 'DEFAULT' or form.orderbyEnum == '' \">\n" +
            " order by p.created_date desc \n" +
            "</if>" +
            "</script>")
    List<ProjectInfoBo>  listAllPage(@Param("form") ProjectInfoForm form, Page<ProjectInfoBo> page);

    /**
     * 项目详情
     * @param id
     * @return
     */
    @Select("SELECT\n" +
            " p.*,u.name as userName,u.sex,u.company,u.duties,u.avatar_url,u.telephone \n" +
            " FROM\n" +
            " t_project_info p,\n" +
            " t_user_info u \n" +
            " WHERE\n" +
            " p.open_id = u.open_id \n" +
            " AND p.is_deleted=0 AND u.is_deleted=0 \n" +
            " AND p.id = #{id}")
    ProjectInfoBo queryProjectDetail(@Param("id") String id);
}
