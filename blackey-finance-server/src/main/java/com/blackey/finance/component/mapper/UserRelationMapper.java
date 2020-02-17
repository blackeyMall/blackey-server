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
import org.apache.ibatis.annotations.Update;

import java.util.List;


/**
 * 用户好友关联表 UserRelationMapper
 *
 * @author kaven
 * @date 2018-12-07 09:40:20
 */

public interface UserRelationMapper extends BaseDAO<UserRelation> {

    @Select("<script>SELECT\n" +
            "\t* \n" +
            "FROM\n" +
            "\tt_user_info ui \n" +
            "WHERE\n" +
            "\tui.open_id IN (\n" +
            "\tSELECT\n" +
            "\t\tur.open_id AS friends \n" +
            "\tFROM\n" +
            "\t\tt_user_relation ur \n" +
            "\tWHERE\n" +
            "\t\tur.friend_id = #{form.openId} \n" +
            "<if test=\"form.status != null\">" +
            "AND ur.`status` = #{form.status.value}\n" +
            "</if>" +
            "\t\tAND ur.is_deleted = 0 UNION ALL\n" +
            "\tSELECT\n" +
            "\t\tur.friend_id AS friends \n" +
            "\tFROM\n" +
            "\t\tt_user_relation ur \n" +
            "\tWHERE\n" +
            "\t\tur.open_id = #{form.openId} \n" +
            "<if test=\"form.status != null\">" +
            "\t\tAND ur.`status` = #{form.status.value} \n" +
            "</if>" +
            "\tAND ur.is_deleted = 0 \n" +
            "\t)" +
            "ORDER BY ui.duties desc,ui.company desc,ui.company_brief desc</script>")
    List<UserRelationBo> findUserRelationByOpenId(@Param("form") UserRelationForm form, Page page);


    @Update("UPDATE t_user_relation SET `status` = #{form.status.value} WHERE " +
            "open_id = #{form.friendId} and friend_id = #{form.openId} and is_deleted = 0")
    void updateByFriend(@Param("form") UserRelationForm form);

    @Select("<script>SELECT\n" +
            "\t* \n" +
            "FROM\n" +
            "\tt_user_info ui \n" +
            "WHERE\n" +
            "\tui.open_id IN (\n" +
            "\tSELECT\n" +
            "\t\tur.open_id AS friends \n" +
            "\tFROM\n" +
            "\t\tt_user_relation ur \n" +
            "\tWHERE\n" +
            "\t\tur.friend_id = #{form.openId} \n" +
            "<if test=\"form.status != null\">" +
            "AND ur.`status` = #{form.status.value}\n" +
            "</if>" +
            "\t\tAND ur.is_deleted = 0\n" +
            "\t)</script>")
    List<UserRelationBo> findUserApplyRelationByOpenId(@Param("form") UserRelationForm form, Page page);

    @Select("SELECT\n" +
            "\tu.* \n" +
            "FROM\n" +
            "\tt_user_relation u \n" +
            "WHERE\n" +
            "\t(\n" +
            "\t\tu.open_id = #{form.openId} \n" +
            "\t\tAND u.friend_id = #{form.friendId} \n" +
            "\t) \n" +
            "\tOR (\n" +
            "\t\tu.friend_id = #{form.openId}\n" +
            "\tAND u.open_id = #{form.friendId}\n" +
            "\t)" +
            "and u.is_deleted = 0")
    UserRelation findRelation(@Param("form") UserRelationForm form);


    @Update("UPDATE \n" +
            "\tt_user_relation t \n" +
            "\tSET t.is_deleted = 1\n" +
            "\t\n" +
            "WHERE\n" +
            "(\n" +
            "\t\tt.friend_id = #{form.openId} \n" +
            "\t\tAND t.open_id = #{form.friendId} \n" +
            "\t) \n" +
            "\tOR (\n" +
            "\t\tt.friend_id = #{form.friendId} \n" +
            "\tAND t.open_id = #{form.openId} \n" +
            "\t)\n" +
            "\tAND \n" +
            "\tt.is_deleted = 0 ")
    void fakeDelete(@Param("form") UserRelationForm form);
}
