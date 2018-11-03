package com.blackey.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户 Mapper 接口
 *
 * @author itachi
 * @date 2018-10-05 16:51
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 查询分页列表
     *
     * @author itachi
     * @date 2018-10-05 17:25
     */
    List<User> queryPage(Page page, @Param("user") User userQuery);
}
