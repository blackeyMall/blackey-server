package com.blackey.admin.component.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackey.admin.component.domain.SysRoleDept;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色与部门对应关系 SysRoleDeptMapper
 * 
 * @author kavenW
 * @date 2018-06-29 14:18:32
 */
@Mapper
public interface SysRoleDeptMapper extends BaseMapper<SysRoleDept> {
	
}
