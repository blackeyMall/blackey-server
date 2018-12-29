package com.blackey.admin.component.mapper;

import com.blackey.admin.component.domain.SysTenantMenu;
import com.blackey.mybatis.dao.BaseDAO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 租户菜单关联表 SysTenantMenuMapper
 * 
 * @author kaven
 * @date 2018-12-22 14:33:05
 */

public interface SysTenantMenuMapper extends BaseDAO<SysTenantMenu> {

    /**
     * 查询订单id
     * @param id
     * @return
     */
    @Select("SELECT tm.menu_id FROM sys_tenant_menu tm WHERE tm.tenant_id = #{id}")
    List<Long> queryMenuIdByTenantId(@Param("id") Long id);
}
