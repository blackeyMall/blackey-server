package com.blackey.admin.component.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackey.admin.component.domain.SysDict;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据字典表 SysDictMapper
 * 
 * @author kavenW
 * @date 2018-06-29 14:18:32
 */
@Mapper
public interface SysDictMapper extends BaseMapper<SysDict> {
	
}
