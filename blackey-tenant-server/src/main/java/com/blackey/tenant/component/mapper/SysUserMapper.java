package com.blackey.tenant.component.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.tenant.component.domain.SysUserEntity;
import com.blackey.tenant.dto.form.SysUserForm;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;

/**
 * 系统用户
 * 
 * @author kavenW
 *
 * @date 2016年9月18日 上午9:34:11
 */

public interface SysUserMapper extends BaseMapper<SysUserEntity> {
	
	/**
	 * 查询用户的所有权限
	 * @param userId  用户ID
	 */
	List<String> queryAllPerms(Long userId);
	
	/**
	 * 查询用户的所有菜单ID
	 */
	List<Long> queryAllMenuId(Long userId);
	
	/**
	 * 根据用户名，查询系统用户
	 */
	SysUserEntity queryByUserName(String username);

	/**
	 * 分页查询用户信息
	 * @param form
	 * @param page
	 * @return
	 */
	@Select("<script>" +
			"SELECT\n" +
			"\tu.*,\n" +
			"\tt.company AS tenantName \n" +
			"FROM\n" +
			"\tsys_user u\n" +
			"\tLEFT JOIN sys_tenant_info t ON u.tenant_id = t.id" +
			" Where 1 = 1 " +
			"<if test=\"form.userName != null and form.userName != '' \">" +
			" AND u.username like concat('%', #{form.userName}, '%')" +
			"</if>" +
			"<if test=\"form.createUserId != null and form.createUserId != '' \">" +
			" AND u.create_user_id = #{form.createUserId}" +
			"</if>" +
			"</script>")
    List<SysUserEntity> queryPage(@Param("form") SysUserForm form, Page<SysUserEntity> page);
}
