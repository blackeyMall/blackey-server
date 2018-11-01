package com.blackey.admin.component.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackey.admin.component.domain.SysConfigEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 系统配置信息
 * 
 * @author kavenW
 *
 * @date 2016年12月4日 下午6:46:16
 */
@Mapper
public interface SysConfigMapper extends BaseMapper<SysConfigEntity> {

	/**
	 * 根据key，查询value
	 */
	SysConfigEntity queryByKey(String paramKey);

	/**
	 * 根据key，更新value
	 */
	int updateValueByKey(@Param("paramKey") String paramKey, @Param("paramValue") String paramValue);
	
}
