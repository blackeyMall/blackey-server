package com.blackey.admin.component.mapper;

import com.blackey.admin.component.domain.SysRoleMenu;
import com.blackey.mybatis.dao.BaseDAO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 角色与菜单对应关系 SysRoleMenuMapper
 * 
 * @author kaven
 * @date 2018-12-18 14:45:19
 */

public interface SysRoleMenuMapper extends BaseDAO<SysRoleMenu> {

    /**
     * 根据角色ID，获取菜单ID列表
     * @param roleId
     * @return
     */

    @Select("<script>" +
            "select menu_id from sys_role_menu " +
            "where role_id = #{roleId} "+
            " and is_deleted = 0"+
            "</script>")
    List<String> queryMenuIdListByRoleId(@Param("roleId") String roleId);
}
