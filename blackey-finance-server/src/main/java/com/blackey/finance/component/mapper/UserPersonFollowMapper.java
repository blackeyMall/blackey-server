package com.blackey.finance.component.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.finance.component.domain.UserPersonFollow;
import com.blackey.finance.dto.bo.UserPersonFollowBo;
import com.blackey.finance.dto.bo.UserRelationBo;
import com.blackey.finance.dto.form.UserPersonFollowForm;
import com.blackey.finance.dto.form.UserRelationForm;
import com.blackey.mybatis.dao.BaseDAO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 用户关注用户表 UserPersonFollowMapper
 * 
 * @author kaven
 * @date 2018-12-07 09:40:20
 */

public interface UserPersonFollowMapper extends BaseDAO<UserPersonFollow> {



    @Select("SELECT\n" +
            "\tui.* \n" +
            "FROM\n" +
            "\tt_user_person_follow up,\n" +
            "\tt_user_info ui \n" +
            "WHERE\n" +
            "\tup.person_id = ui.open_id \n" +
            "\tAND up.open_id = #{form.openId} \n" +
            "\tAND up.is_deleted = 0 \n" +
            "\tAND ui.is_deleted = 0")
    List<UserPersonFollowBo> findUserFollowByOpenId(@Param("form") UserPersonFollowForm form, Page page);
}
