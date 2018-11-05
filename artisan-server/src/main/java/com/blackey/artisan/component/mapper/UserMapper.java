package com.blackey.artisan.component.mapper;

import com.blackey.artisan.component.domain.User;
import com.blackey.mybatis.dao.BaseDAO;


/**
 *  UserMapper
 * 
 * @author kavenW
 * @date 2018-11-04 21:12:23
 */

public interface UserMapper extends BaseDAO<User> {


    User queryByOpenid(String openId);
	
}
