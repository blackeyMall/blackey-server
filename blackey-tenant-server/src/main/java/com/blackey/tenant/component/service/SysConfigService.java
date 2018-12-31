package com.blackey.tenant.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.tenant.component.domain.SysConfigEntity;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 系统配置信息
 * 
 * @author kavenW
 *
 * @date 2016年12月4日 下午6:49:01
 */
public interface SysConfigService extends BaseService<SysConfigEntity> {

	PageUtils queryPage(Map<String, Object> params);
	
	/**
	 * 保存配置信息
	 */
	void saveConfig(SysConfigEntity config);
	
	/**
	 * 更新配置信息
	 */
	void updateConfig(SysConfigEntity config);
	
	/**
	 * 根据key，更新value
	 */
	void updateValueByKey(String key, String value);
	
	/**
	 * 删除配置信息
	 */
	void deleteBatch(Long[] ids);
	
	/**
	 * 根据key，获取配置的value值
	 * 
	 * @param key           key
	 */
	String getValue(String key);
	
	/**
	 * 根据key，获取value的Object对象
	 * @param key    key
	 * @param clazz  Object对象
	 */
	<T> T getConfigObject(String key, Class<T> clazz);
	
}
