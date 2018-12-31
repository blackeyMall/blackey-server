package com.blackey.admin.component.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.admin.component.domain.SysConfig;
import com.blackey.admin.component.mapper.SysConfigMapper;
import com.blackey.admin.component.service.SysConfigService;
import com.blackey.admin.global.constants.AdminConstants;
import com.blackey.admin.global.constants.StatusEnum;
import com.blackey.common.exception.BusinessException;
import com.blackey.common.result.ResultCodeEnum;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;
import com.blackey.redis.service.RedisService;
import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;

/**
 * 系统配置信息表 SysConfigServiceImpl
 *
 * @author kaven
 * @date 2018-12-18 14:45:19
 */
@Service
public class SysConfigServiceImpl extends BaseServiceImpl<SysConfigMapper, SysConfig> implements SysConfigService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysConfigServiceImpl.class);

    @Resource
    RedisService redisService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String paramKey = (String)params.get("paramKey");

        Page<SysConfig> page = (Page<SysConfig>) this.page(
                new Query<SysConfig>(params).getPage(),
                new QueryWrapper<SysConfig>()
                        .like(StringUtils.isNotBlank(paramKey),"param_key", paramKey)
                        .eq("status", StatusEnum.SATUS_EANBLE.getCode())
        );
        return new PageUtils(page);
    }

    /**
     * 保存配置信息
     *
     * @param config
     */
    @Override
    public void saveConfig(SysConfig config) {
        baseMapper.insert(config);
        redisService.set(AdminConstants.RedisKeyInterface.SYS_CONFIG_KEY
                +config.getTenantId()+":"+config.getParamKey(),config);
    }

    /**
     * 更新配置信息
     *
     * @param config
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateConfig(SysConfig config) {
        baseMapper.updateById(config);
        redisService.set(AdminConstants.RedisKeyInterface.SYS_CONFIG_KEY
                +config.getTenantId()+":"+config.getParamKey(),config);
    }

    /**
     * 根据key，更新value
     * @param tenantId
     * @param key
     * @param value
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateValueByKey(String tenantId,String key, String value) {
        SysConfig config = baseMapper.selectOne(new QueryWrapper<SysConfig>().eq("tenant_id", tenantId)
                .eq("param_key", key).orderByDesc("created_date"));
        if(null == config){
            throw new BusinessException(ResultCodeEnum.NOT_FOUND);
        }
        config.setParamValue(value);
        baseMapper.updateById(config);
        redisService.set(AdminConstants.RedisKeyInterface.SYS_CONFIG_KEY
                +config.getTenantId()+":"+config.getParamKey(),config);

    }

    /**
     * 删除配置信息
     *
     * @param ids
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(String[] ids) {

        for(String id : ids){
            SysConfig config = this.getById(id);
            redisService.delete(AdminConstants.RedisKeyInterface.SYS_CONFIG_KEY
                    +config.getTenantId()+":"+config.getParamKey());
        }
        this.removeByIds(Arrays.asList(ids));
    }

    /**
     * 根据key，获取配置的value值
     * @param tenantId
     * @param key
     * @return
     */
    @Override
    public String getValue(String tenantId,String key) {
        SysConfig config = (SysConfig)redisService.get(AdminConstants.RedisKeyInterface.SYS_CONFIG_KEY
                +tenantId+":"+key);
        if(config == null){
            config = baseMapper.selectOne(new QueryWrapper<SysConfig>().eq("tenant_id", tenantId)
                    .eq("param_key", key).orderByDesc("created_date"));
            redisService.set(AdminConstants.RedisKeyInterface.SYS_CONFIG_KEY
                    +tenantId+":"+key,config);
        }

        return config == null ? null : config.getParamValue();
    }

    /**
     * 根据key，获取value的Object对象
     * @param tenantId
     * @param key   key
     * @param clazz Object对象
     * @return
     */
    @Override
    public <T> T getConfigObject(String tenantId,String key, Class<T> clazz) {
        String value = getValue(tenantId,key);
        if(StringUtils.isNotBlank(value)){
            return new Gson().fromJson(value, clazz);
        }

        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new BusinessException(ResultCodeEnum.INVALID_REQUEST);
        }
    }

}
