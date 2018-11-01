package com.blackey.admin.component.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackey.admin.component.domain.SysLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统日志
 * 
 * @author kavenW
 *
 * @date 2017-03-08 10:40:56
 */
@Mapper
public interface SysLogMapper extends BaseMapper<SysLogEntity> {
	
}
