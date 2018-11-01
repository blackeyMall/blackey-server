package com.blackey.admin.component.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackey.admin.component.domain.SysCaptchaEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 验证码
 *
 * @author Mark sunlightcs@gmail.com
 * @since 3.1.0 2018-02-10
 */
@Mapper
public interface SysCaptchaMapper extends BaseMapper<SysCaptchaEntity> {

}
