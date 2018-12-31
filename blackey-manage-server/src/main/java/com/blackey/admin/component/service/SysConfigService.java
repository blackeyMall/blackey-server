package com.blackey.admin.component.service;

import com.blackey.admin.component.domain.SysConfig;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;

import java.util.Map;

/**
 * 系统配置信息表 SysConfigService
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
public interface SysConfigService extends BaseService<SysConfig> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存配置信息
     * @param config
     */
    void saveConfig(SysConfig config);

    /**
     * 更新配置信息
     * @param config
     */
    void updateConfig(SysConfig config);

    /**
     * 根据key，更新value
     * @param tenantId
     * @param key
     * @param value
     */
    void updateValueByKey(String tenantId,String key, String value);

    /**
     * 删除配置信息
     * @param ids
     */
    void deleteBatch(String[] ids);

    /**
     * 根据tenantId,key，获取配置的value值
     * @param tenantId
     * @param key
     * @return
     */
    String getValue(String tenantId,String key);


    /**
     *
     * 根据key，获取value的Object对象
     * @param tenantId
     * @param key    key
     * @param clazz  Object对象
     * @return
     */
    <T> T getConfigObject(String tenantId,String key, Class<T> clazz);

}

