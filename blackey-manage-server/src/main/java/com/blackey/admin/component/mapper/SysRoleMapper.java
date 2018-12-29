package com.blackey.admin.component.mapper;

import com.blackey.admin.component.domain.SysRole;
import com.blackey.mybatis.dao.BaseDAO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 角色 SysRoleMapper
 * 
 * @author kaven
 * @date 2018-12-18 14:45:19
 */

public interface SysRoleMapper extends BaseDAO<SysRole> {

    /**
     * 查询用户创建的角色id
     * @param createdBy
     * @return
     */
    @Select("select role_id from sys_role " +
            "where created_by = #{createdBy} and is_deleted = 0" +
            "order by created_date desc")
    List<String> queryRoleIdList(@Param("createdBy") String createdBy);
}
