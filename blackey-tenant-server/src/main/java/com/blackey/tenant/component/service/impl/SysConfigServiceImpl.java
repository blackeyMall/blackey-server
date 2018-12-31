package com.blackey.tenant.component.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.common.exception.BusinessException;
import com.blackey.common.result.ResultCodeEnum;
import com.blackey.mybatis.service.impl.BaseServiceImpl;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.mybatis.utils.Query;
import com.blackey.redis.service.RedisService;
import com.blackey.tenant.component.domain.SysConfigEntity;
import com.blackey.tenant.component.mapper.SysConfigMapper;
import com.blackey.tenant.component.service.SysConfigService;
import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;

@Service("sysConfigService")
public class SysConfigServiceImpl extends BaseServiceImpl<SysConfigMapper, SysConfigEntity> implements SysConfigService {

    @Resource
	RedisService redisService;

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String paramKey = (String)params.get("paramKey");

		Page<SysConfigEntity> page = (Page<SysConfigEntity>) this.page(
				new Query<SysConfigEntity>(params).getPage(),
				new QueryWrapper<SysConfigEntity>()
					.like(StringUtils.isNotBlank(paramKey),"param_key", paramKey)
					.eq("status", 1)
		);

		return new PageUtils(page);
	}
	
	@Override
	public void saveConfig(SysConfigEntity config) {
		this.save(config);
		redisService.set(config.getParamKey(),config);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateConfig(SysConfigEntity config) {
		this.updateById(config);
        redisService.set(config.getParamKey(),config);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateValueByKey(String key, String value) {
		baseMapper.updateValueByKey(key, value);
		redisService.delete(key);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteBatch(Long[] ids) {
		for(Long id : ids){
			SysConfigEntity config = this.getById(id);
            redisService.delete(config.getParamKey());
		}

		this.removeByIds(Arrays.asList(ids));
	}

	@Override
	public String getValue(String key) {
		SysConfigEntity config = (SysConfigEntity)redisService.get(key);
		if(config == null){
			config = baseMapper.queryByKey(key);
            redisService.set(key,config);
		}

		return config == null ? null : config.getParamValue();
	}
	
	@Override
	public <T> T getConfigObject(String key, Class<T> clazz) {
		String value = getValue(key);
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
