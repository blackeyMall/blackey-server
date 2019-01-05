package com.blackey.tenant.component.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.common.exception.BusinessException;
import com.blackey.common.exception.PermissionException;
import com.blackey.common.result.ResultCodeEnum;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;
import com.blackey.tenant.component.domain.SysRoleEntity;
import com.blackey.tenant.component.domain.SysUserEntity;
import com.blackey.tenant.component.mapper.SysRoleMapper;
import com.blackey.tenant.component.service.SysRoleMenuService;
import com.blackey.tenant.component.service.SysRoleService;
import com.blackey.tenant.component.service.SysUserRoleService;
import com.blackey.tenant.component.service.SysUserService;
import com.blackey.tenant.global.constants.RoleEnum;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 角色
 * 
 * @author kavenW
 *
 * @date 2016年9月18日 上午9:45:12
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleMapper, SysRoleEntity> implements SysRoleService {
	@Autowired
	private SysRoleMenuService sysRoleMenuService;
	@Autowired
	private SysUserService sysUserService;
    @Autowired
    private SysUserRoleService sysUserRoleService;

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String roleName = (String)params.get("roleName");
		Long createUserId = (Long)params.get("createUserId");
		Long tenantId = (Long)params.get("tenantId");

		Page<SysRoleEntity> page = (Page<SysRoleEntity>) this.page(
			new Query<SysRoleEntity>(params).getPage(),
			new QueryWrapper<SysRoleEntity>()
				.like(StringUtils.isNotBlank(roleName),"role_name", roleName)
				.eq(createUserId != null,"create_user_id", createUserId)
				.eq(tenantId != null,"tenant_id",tenantId)
		);

		return new PageUtils(page);
	}

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveRole(SysRoleEntity role) {
        role.setCreateTime(new Date());
        this.save(role);

        //检查权限是否越权
        checkPrems(role);

        //保存角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRole(SysRoleEntity role) {
        this.updateById(role);

        //检查权限是否越权
        checkPrems(role);

        //更新角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Long[] roleIds) {
        //删除角色
        this.removeByIds(Arrays.asList(roleIds));

        //删除角色与菜单关联
        sysRoleMenuService.deleteBatch(roleIds);

        //删除角色与用户关联
        sysUserRoleService.deleteBatch(roleIds);
    }


    @Override
	public List<Long> queryRoleIdList(Long createUserId) {
		return baseMapper.queryRoleIdList(createUserId);
	}

	/**
	 * 检查权限是否越权
	 */
	private void checkPrems(SysRoleEntity role){

		SysUserEntity userEntity = sysUserService.getById(role.getCreateUserId());
		if(null == userEntity){
			throw new BusinessException(ResultCodeEnum.NOT_FOUND);
		}
		//如果不是超级管理员/租户管理员，则需要判断角色的权限是否超过自己的权限
		if(userEntity.getRoleType() == RoleEnum.ROLE_SUPER.getCode()
				|| userEntity.getRoleType() == RoleEnum.ROLE_ADMIN.getCode()){
			return ;
		}
		
		//查询用户所拥有的菜单列表
		List<Long> menuIdList = sysUserService.queryAllMenuId(role.getCreateUserId());
		
		//判断是否越权
		if(!menuIdList.containsAll(role.getMenuIdList())){
			throw new PermissionException();
		}
	}
}
