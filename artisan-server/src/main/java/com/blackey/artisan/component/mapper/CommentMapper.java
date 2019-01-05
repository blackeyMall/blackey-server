package com.blackey.artisan.component.mapper;

import com.blackey.artisan.component.domain.Comment;
import com.blackey.mybatis.dao.BaseDAO;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 *  CommentMapper
 * 
 * @author kaven
 * @date 2019-01-02 09:47:38
 */

public interface CommentMapper extends BaseDAO<Comment> {


    /**
     * 通过openid查询评论详情
     * @param openid
     * @return
     */
    @Select("SELECT\n" +
            "\tc.* \n" +
            "FROM\n" +
            "\t`comment` c,\n" +
            "\torder_info o \n" +
            "WHERE\n" +
            "\to.id = c.service_id \n" +
            "\tAND o.open_id = #{openid}")
    List<Comment> getByOpenid(String openid);
	
}
