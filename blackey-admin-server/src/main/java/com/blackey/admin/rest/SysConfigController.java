package com.blackey.admin.rest;

import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.admin.component.domain.SysConfigEntity;
import com.blackey.admin.component.service.SysConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 系统配置信息
 * 
 * @author kavenW
 *
 * @date 2016年12月4日 下午6:55:53
 */
@RestController
@RequestMapping("/sys/config")
public class SysConfigController extends AbstractController {
	@Autowired
	private SysConfigService sysConfigService;
	
	/**
	 * 所有配置列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("sys:config:list")
	public Result list(@RequestParam Map<String, Object> params){
		PageUtils page = sysConfigService.queryPage(params);

		return success(page);
	}
	
	
	/**
	 * 配置信息
	 */
	@GetMapping("/info/{id}")
	@RequiresPermissions("sys:config:info")
	public Result info(@PathVariable("id") Long id){
		SysConfigEntity config = sysConfigService.getById(id);
		
		return success(config);
	}
	
	/**
	 * 保存配置
	 */
	@PostMapping("/save")
	@RequiresPermissions("sys:config:save")
	public Result save(@RequestBody SysConfigEntity config){

		sysConfigService.saveConfig(config);
		
		return success();
	}
	
	/**
	 * 修改配置
	 */
	@PostMapping("/update")
	@RequiresPermissions("sys:config:update")
	public Result update(@RequestBody SysConfigEntity config){

		sysConfigService.updateConfig(config);
		
		return success();
	}
	
	/**
	 * 删除配置
	 */
	@PostMapping("/delete")
	@RequiresPermissions("sys:config:delete")
	public Result delete(@RequestBody Long[] ids){
		sysConfigService.deleteBatch(ids);
		
		return success();
	}

}
