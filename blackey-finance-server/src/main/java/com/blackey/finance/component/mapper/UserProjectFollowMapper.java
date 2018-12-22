package com.blackey.finance.component.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.finance.component.domain.UserProjectFollow;
import com.blackey.finance.dto.bo.ProjectInfoBo;
import com.blackey.finance.dto.form.ProjectInfoForm;
import com.blackey.mybatis.dao.BaseDAO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 用户关注项目表 UserProjectFollowMapper
 * 
 * @author kaven
 * @date 2018-12-07 09:40:20
 */

public interface UserProjectFollowMapper extends BaseDAO<UserProjectFollow> {

    /**
     * 我关注的项目分页
     * @param form
     * @param page
     * @return
     */
    @Select("<script>" +
            "SELECT p.* ,up.created_date,u.name AS userName,u.sex,u.company,u.duties FROM t_user_project_follow up,t_project_info p" +
            ",t_user_info u \n" +
            "WHERE up.project_id = p.id and u.open_id = p.open_id " +
            " AND up.is_deleted = 0 and p.is_deleted = 0 and u.is_deleted = 0 "+
            " and p.audit_status = 'SUCCESS' "+
            "<if test=\"form.openId != '' and form.openId != null\">" +
            " and up.open_id = #{form.openId}\n" +
            "</if>" +
            "<if test=\"form.orderbyEnum.value == 'FOLLOWNUM' \">\n" +
            " order by p.follow_num desc \n" +
            "</if>" +
            "<if test=\"form.orderbyEnum.value == 'LIKENUM' \">\n" +
            " order by p.like_num desc \n" +
            "</if>" +
            "<if test=\"form.orderbyEnum.value == 'DEFAULT' or form.orderbyEnum == null \">\n" +
            " order by up.created_date desc \n" +
            "</if>" +
            "</script>")
    List<ProjectInfoBo> queryPage(@Param("form") ProjectInfoForm form, Page<ProjectInfoBo> page);
}
