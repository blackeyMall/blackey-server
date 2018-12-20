package com.blackey.finance.component.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.finance.component.domain.UserInfo;
import com.blackey.finance.component.domain.UserRelation;
import com.blackey.finance.dto.bo.UserRelationBo;
import com.blackey.finance.dto.form.UserRelationForm;
import com.blackey.finance.global.constants.ApplyStatus;
import com.blackey.mybatis.dao.BaseDAO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 用户好友关联表 UserRelationMapper
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */

public interface UserRelationMapper extends BaseDAO<UserRelation> {


    @Select("<script>SELECT\n" +
            "\tui.*,ur.status\n" +
            "FROM\n" +
            "\tt_user_relation ur,\n" +
            "\tt_user_info ui\n" +
            "WHERE\n" +
            "\tur.friend_id = ui.open_id\n" +
            "<if test=\"form.openId != '' and form.openId != null\">" +
            "AND ur.open_id = #{form.openId}\n" +
            "</if>" +
            "<if test=\"form.status != null\">" +
            "AND ur.`status` = #{form.status.value}\n" +
            "</if>" +
            "AND ui.is_deleted = 0\n" +
            "AND ur.is_deleted = 0</script>")
    List<UserRelationBo> findUserRelationByOpenId(@Param("form") UserRelationForm form, Page page);
}
