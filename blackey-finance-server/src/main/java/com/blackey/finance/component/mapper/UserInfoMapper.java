package com.blackey.finance.component.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.finance.component.domain.UserInfo;
import com.blackey.finance.dto.bo.UserInfoBo;
import com.blackey.mybatis.dao.BaseDAO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 用户信息表 UserInfoMapper
 * 
 * @author kaven
 * @date 2018-12-07 09:40:20
 */

public interface UserInfoMapper extends BaseDAO<UserInfo> {


    UserInfoBo findByOpenid(String openid);

    void updateByOpenid(String openid);

    /**
     * 查询所有没有关系的用户
     */
    @Select("SELECT\n" +
            "\t* \n" +
            "FROM\n" +
            "\tt_user_info t\n" +
            "WHERE\n" +
            "\tt.open_id NOT IN(\n" +
            "\tSELECT\n" +
            "\t\tup.person_id \n" +
            "\tFROM\n" +
            "\t\tt_user_person_follow up \n" +
            "\tWHERE\n" +
            "\t\tup.open_id = #{openId} \n" +
            "\tand up.is_deleted = 0\n" +
            "\t) \n" +
            "\tAND t.open_id NOT IN(SELECT\n" +
            "                ur.open_id AS friends \n" +
            "            FROM\n" +
            "                t_user_relation ur \n" +
            "            WHERE\n" +
            "                ur.friend_id = #{openId} \n" +
            "                AND ur.`status` != 'REFUSE' \n" +
            "                AND ur.is_deleted = 0 \n" +
            "            UNION\n" +
            "            ALL SELECT\n" +
            "                ur.friend_id AS friends \n" +
            "            FROM\n" +
            "                t_user_relation ur \n" +
            "            WHERE\n" +
            "                ur.open_id = #{openId} \n" +
            "                AND ur.`status` != 'REFUSE' \n" +
            "                AND ur.is_deleted = 0 )\n" +
            "\tAND t.open_id != #{openId}" +
            "\tand t.is_deleted = 0")
    List<UserInfoBo> queryAllUserWithoutRelation(@Param("openId") String openId, Page page);

}
