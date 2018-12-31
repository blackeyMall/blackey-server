package com.blackey.admin.component.mapper;

import com.blackey.admin.component.domain.SysConfig;
import com.blackey.mybatis.dao.BaseDAO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


/**
 * 系统配置信息表 SysConfigMapper
 * 
 * @author kaven
 * @date 2018-12-18 14:45:19
 */

public interface SysConfigMapper extends BaseDAO<SysConfig> {

    /**
     * 根据tenantId 和key 查询配置信息
     * @param tenantId
     * @param key
     * @return
     */
    @Select("<script>" +
            "select * from sys_user where " +
            "tenant_id = #{tenantId}" +
            "and param_key = #{key}" +
            " and is_deleted = 0"+
            "</script>")
    default SysConfig queryByTenantIdAndKey(@Param("tenantId") String tenantId, @Param("key") String key) {
        return null;
    }
}
