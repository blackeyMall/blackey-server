package com.blackey.finance.component.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.finance.component.domain.UserRequireFollow;
import com.blackey.finance.dto.bo.RequirementInfoBo;
import com.blackey.finance.dto.bo.UserRequireFollowBo;
import com.blackey.finance.dto.form.RequirementInfoForm;
import com.blackey.finance.dto.form.UserRequireFollowForm;
import com.blackey.mybatis.dao.BaseDAO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 用户需求关注表 UserRequireFollowMapper
 * 
 * @author kaven
 * @date 2018-12-07 09:40:20
 */

public interface UserRequireFollowMapper extends BaseDAO<UserRequireFollow> {

    /**
     * 我的关注分页查询
     * @param form
     * @param page
     * @return
     */
    @Select("<script>" +
            "SELECT r.* ,ur.created_date,u.name,u.sex,u.company,u.duties,u.avatar_url FROM t_user_require_follow ur,t_requirement_info r" +
            ",t_user_info u \n" +
            "WHERE ur.require_id = r.id and u.open_id = r.open_id " +
            "AND ur.is_deleted = 0 and r.is_deleted = 0 and u.is_deleted = 0 "+
            " and r.audit_status = 'SUCCESS' "+
            "<if test=\"form.openId != '' and form.openId != null\">" +
            " and ur.open_id = #{form.openId}\n" +
            "</if>" +
            "<if test=\"form.orderbyEnum.value == 'FOLLOWNUM' \">\n" +
            " order by r.follow_num desc \n" +
            "</if>" +
            "<if test=\"form.orderbyEnum.value == 'LIKENUM' \">\n" +
            " order by r.like_num desc \n" +
            "</if>" +
            "<if test=\"form.orderbyEnum.value == 'DEFAULT' or form.orderbyEnum.value == '' \">\n" +
            " order by ur.created_date desc \n" +
            "</if>" +
            "</script>")
    List<RequirementInfoBo> queryPage(@Param("form") RequirementInfoForm form, Page<RequirementInfoBo> page);
}
