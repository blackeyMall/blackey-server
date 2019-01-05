package com.blackey.tenant.rest;

import com.blackey.common.result.ResultCodeEnum;
import com.blackey.tenant.component.domain.SysUserEntity;
import com.blackey.tenant.component.service.SysTenantMenuService;
import com.blackey.tenant.global.constants.RoleEnum;
import com.blackey.common.exception.BusinessException;
import com.blackey.common.result.Result;
import com.blackey.tenant.component.domain.SysMenuEntity;
import com.blackey.tenant.component.service.ShiroService;
import com.blackey.tenant.component.service.SysMenuService;
import com.blackey.tenant.dto.NavVO;
import com.blackey.tenant.dto.form.SysMenuEntityForm;
import com.blackey.tenant.global.constants.MenuEnum;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * 系统菜单
 * 
 * @author kavenW
 *
 * @date 2016年10月27日 下午9:58:15
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends AbstractController {
	@Autowired
	private SysMenuService sysMenuService;
	@Autowired
	private ShiroService shiroService;
	@Autowired
	SysTenantMenuService sysTenantMenuService;

	/**
	 * 导航菜单
	 */
	@GetMapping("/nav")
	public Result nav(){
        NavVO navVO = new NavVO();
		List<SysMenuEntity> menuList = sysMenuService.getUserMenuList(getUser());
		Set<String> permissions = shiroService.getUserPermissions(getUser());
        navVO.setMenuList(menuList);
        navVO.setPermissions(permissions);
		return success(navVO);
	}
	
	/**
	 * 所有菜单列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("sys:menu:list")
	public Result list(){
		List<SysMenuEntity> menuList ;
		SysUserEntity sysUserEntity = getUser();
		if(RoleEnum.ROLE_SUPER.getCode() == sysUserEntity.getRoleType()){
			//超级管理员 查询所有菜单
			menuList = sysMenuService.list(null);
		}else {
			menuList = sysMenuService.queryMenuByTenantId(getTenangtId());
		}
        menuList.forEach(sysMenuEntity -> {
            SysMenuEntity parentMenuEntity = sysMenuService.getById(sysMenuEntity.getParentId());
            if (parentMenuEntity != null) {
                sysMenuEntity.setParentName(parentMenuEntity.getName());
            }
        });

		return success(menuList);
	}
	
	/**
	 * 选择菜单(添加、修改菜单)
	 */
	@GetMapping("/select")
	@RequiresPermissions("sys:menu:select")
	public Result select(){
		//查询列表数据
		List<SysMenuEntity> menuList = sysMenuService.queryNotButtonList();
		
		//添加顶级菜单
		SysMenuEntity root = new SysMenuEntity();
		root.setMenuId(0L);
		root.setName("一级菜单");
		root.setParentId(-1L);
		root.setOpen(true);
		menuList.add(root);
		
		return success(menuList);
	}
	
	/**
	 * 菜单信息
	 */
	@GetMapping("/info/{menuId}")
	@RequiresPermissions("sys:menu:info")
	public Result info(@PathVariable("menuId") Long menuId){
		SysMenuEntity menu = sysMenuService.getById(menuId);
		return success(menu);
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	@RequiresPermissions("sys:menu:save")
	public Result save(@RequestBody SysMenuEntityForm menu){
		//数据校验
		verifyForm(menu);
        SysMenuEntity sysMenuEntity = new SysMenuEntity();
        BeanUtils.copyProperties(menu,sysMenuEntity);
		sysMenuService.save(sysMenuEntity);
		
		return success();
	}
	
	/**
	 * 修改
	 */
	@PostMapping("/update")
	@RequiresPermissions("sys:menu:update")
	public Result update(@RequestBody SysMenuEntityForm menu){
		//数据校验
		verifyForm(menu);
        SysMenuEntity sysMenuEntity = new SysMenuEntity();
        BeanUtils.copyProperties(menu,sysMenuEntity);
		sysMenuService.updateById(sysMenuEntity);
		
		return success();
	}
	
	/**
	 * 删除
	 */
	@PostMapping("/delete/{menuId}")
	@RequiresPermissions("sys:menu:delete")
	public Result delete(@PathVariable("menuId") long menuId){

		SysMenuEntity sysMenuEntity = sysMenuService.getById(menuId);
		if(null == sysMenuEntity){
			return failure(ResultCodeEnum.NOT_FOUND);
		}
		if(sysMenuEntity.getIsSystemMenu() == MenuEnum.SYS_MENU_YES.getCode()){
			return failure(MenuEnum.VALIDATE_SYSTEM_MENU);
		}
		//判断是否有子菜单或按钮
		List<SysMenuEntity> menuList = sysMenuService.queryListParentId(menuId);
		if(menuList.size() > 0){
			return failure(MenuEnum.EXIST_CHILD_MENU);
		}

		sysMenuService.delete(menuId);

		return success();
	}
	
	/**
	 * 验证参数是否正确
	 */
	private void verifyForm(SysMenuEntityForm menu){

		//上级菜单类型
		int parentType = MenuEnum.CATALOG.getCode();
		if(menu.getParentId() != 0){
			SysMenuEntity parentMenu = sysMenuService.getById(menu.getParentId());
			parentType = parentMenu.getType();
		}
		
		//目录、菜单
		if(menu.getType() == MenuEnum.CATALOG.getCode() ||
				menu.getType() == MenuEnum.MENU.getCode()){
			if(parentType != MenuEnum.CATALOG.getCode()){
				throw new BusinessException(MenuEnum.VALIDATE_MENU);
			}
			return ;
		}
		
		//按钮
		if(menu.getType() == MenuEnum.BUTTON.getCode()){
			if(parentType != MenuEnum.MENU.getCode()){
				throw new BusinessException(MenuEnum.VALIDATE_BUTTON);
			}
			return ;
		}
	}
}
