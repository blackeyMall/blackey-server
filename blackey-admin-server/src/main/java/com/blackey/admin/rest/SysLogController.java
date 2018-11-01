package com.blackey.admin.rest;

import com.blackey.common.result.Result;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.admin.component.service.SysLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * 系统日志
 * 
 * @author kavenW
 *
 * @date 2017-03-08 10:40:56
 */
@RestController
@RequestMapping("/sys/log")
public class SysLogController extends AbstractController{
	@Autowired
	private SysLogService sysLogService;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("sys:log:list")
	public Result list(@RequestParam Map<String, Object> params){
		PageUtils page = sysLogService.queryPage(params);

		return success(page);
	}
	
}
