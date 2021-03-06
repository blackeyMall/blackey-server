package com.blackey.finance.component.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.finance.component.domain.RequirementInfo;
import com.blackey.finance.dto.bo.RequirementInfoBo;
import com.blackey.finance.dto.form.RequirementInfoForm;
import com.blackey.mybatis.dao.BaseDAO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 需求信息表 RequirementInfoMapper
 * 
 * @author kaven
 * @date 2018-12-07 09:40:20
 */

public interface RequirementInfoMapper extends BaseDAO<RequirementInfo> {


    /**
     * 分页查询
     * @param form
     * @param page
     * @return
     */
    @Select("<script>" +
            "SELECT r.*,u.name,u.sex,u.company,u.duties,u.avatar_url  FROM t_requirement_info r left join t_user_info u on r.open_id = u.open_id" +
            " WHERE r.is_deleted = 0 and u.is_deleted = 0 " +
            "<if test=\"form.openId != '' and form.openId != null\">" +
            " and r.open_id = #{form.openId}\n" +
            "</if>" +
            "<if test=\"form.label != null and form.label != '' \">" +
            " and r.label like concat(concat('%',#{form.label}),'%')\n" +
            "</if>" +
            "<if test=\"form.orderbyEnum.value == 'FOLLOWNUM' \">\n" +
            " order by r.follow_num desc \n" +
            "</if>" +
            "<if test=\"form.orderbyEnum.value == 'LIKENUM' \">\n" +
            " order by r.like_num desc \n" +
            "</if>" +
            "<if test=\"form.orderbyEnum.value == 'DEFAULT' or form.orderbyEnum == null \">\n" +
            " order by r.created_date desc \n" +
            "</if>" +
            "</script>")
    List<RequirementInfoBo> queryPage(@Param("form") RequirementInfoForm form, Page<RequirementInfoBo> page);
    /**
     * 分页查询--所有需求
     *
     * @param form
     * @param page
     * @return
     */
    @Select("<script>" +
            "SELECT r.*,u.name,u.sex,u.company,u.duties,u.avatar_url FROM t_requirement_info r left join t_user_info u on r.open_id = u.open_id" +
            "  WHERE r.is_deleted = 0  and u.is_deleted = 0 " +
//            "<if test=\"form.openId != '' and form.openId != null\">" +
//            " and r.open_id != #{form.openId}\n" +
//            "</if>" +
            "<if test=\"form.category != null and form.category.value != 'DEFAULT' \">" +
            " and r.category = #{form.category.value}\n" +
            "</if>" +
            "<if test=\"form.label != null and form.label != '' \">" +
            " and r.label like concat(concat('%',#{form.label}),'%')\n" +
            "</if>" +
            "<if test=\"form.isRecommend != '' and form.isRecommend != null\">" +
            " and r.is_recommend != #{form.isRecommend}\n" +
            "</if>" +
            "<if test=\"form.isTodayPublish != null and form.isTodayPublish == 1\">" +
            " and DATE_FORMAT(r.created_date, '%Y-%m-%d') = DATE_FORMAT(NOW(),'%Y-%m-%d')\n" +
            "</if>"+
            "<if test=\"form.auditStatus != null and form.auditStatus.value != 'DEFAULT' \">" +
            " and r.audit_status = #{form.auditStatus.value}\n" +
            "</if>" +
            "<if test=\"form.orderbyEnum.value == 'FOLLOWNUM' \">\n" +
            " order by r.follow_num desc \n" +
            "</if>" +
            "<if test=\"form.orderbyEnum.value == 'LIKENUM' \">\n" +
            " order by r.like_num desc \n" +
            "</if>" +
            "<if test=\"form.orderbyEnum.value == 'DEFAULT' or form.orderbyEnum == null \">\n" +
            " order by r.created_date desc \n" +
            "</if>" +
            "</script>")
    List<RequirementInfoBo>  listAllPage(@Param("form") RequirementInfoForm form, Page<RequirementInfoBo> page);

    /**
     * 通过需求id查询详情信息
     * @param id
     * @return
     */
    @Select("<script>" +
            "SELECT r.*,u.name,u.sex,u.company,u.duties,u.avatar_url FROM t_requirement_info r left join t_user_info u on r.open_id = u.open_id" +
            "  WHERE r.is_deleted = 0  and u.is_deleted = 0 and r.id = #{id}" +
            "</script>")
    RequirementInfoBo queryDetailById(@Param("id") String id);
}
