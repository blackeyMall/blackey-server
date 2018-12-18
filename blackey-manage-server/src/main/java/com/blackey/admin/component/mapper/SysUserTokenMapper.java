package com.blackey.admin.component.mapper;

import com.blackey.admin.component.domain.SysUserToken;
import com.blackey.mybatis.dao.BaseDAO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


/**
 * 系统用户Token SysUserTokenMapper
 * 
 * @author kaven
 * @date 2018-12-18 14:45:19
 */

public interface SysUserTokenMapper extends BaseDAO<SysUserToken> {

    /**
     * 根据token查询对象
     * @param token
     * @return
     */
    @Select("<script> " +
            "select * from sys_user_token where token = #{token}"+
            "</script>")
    SysUserToken queryByToken(@Param("token") String token);

}
