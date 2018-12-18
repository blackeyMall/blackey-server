package com.blackey.admin.component.mapper;

import com.blackey.admin.component.domain.SysUser;
import com.blackey.mybatis.dao.BaseDAO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 系统用户 SysUserMapper
 * 
 * @author kaven
 * @date 2018-12-18 14:45:19
 */

public interface SysUserMapper extends BaseDAO<SysUser> {

    /**
     * 查询用户的所有权限
     * @param userId  用户ID
     * @return list
     */
    @Select("<script>" +
            "select m.perms from sys_user_role ur \n" +
            " LEFT JOIN sys_role_menu rm on ur.role_id = rm.role_id \n" +
            " LEFT JOIN sys_menu m on rm.menu_id = m.menu_id \n" +
            " where ur.user_id = #{userId}"+
            "</script>")
    List<String> queryAllPerms(@Param("userId") String userId);

    /**
     * 查询用户的所有菜单ID
     * @param userId
     * @return
     */
    @Select("<script>" +
            "select distinct rm.menu_id from sys_user_role ur \n" +
            " LEFT JOIN sys_role_menu rm on ur.role_id = rm.role_id \n" +
            " where ur.user_id = #{userId}"+
            "</script>")
    List<Long> queryAllMenuId(@Param("userId") String userId);

    /**
     * 根据用户名，查询系统用户
     * @param userName
     * @return
     */
    @Select("<script>" +
            "select * from sys_user where user_name = #{userName}"+
            "</script>")
    SysUser queryByUserName(@Param("userName")String userName);

    /**
     * 根据用户id查询管理菜单id
     * @param userId
     * @return
     */
    @Select("<script>" +
            "select distinct rm.menu_id from sys_user_role ur \n" +
            " LEFT JOIN sys_role_menu rm on ur.role_id = rm.role_id \n" +
            " where ur.user_id = #{userId}"+
            "</script>")
    List<String> queryAllMenuIdByUserId(@Param("userId") String userId);
}
