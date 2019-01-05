package com.blackey.artisan.component.mapper;

import com.blackey.artisan.component.domain.Comment;
import com.blackey.artisan.dto.bo.CommentBo;
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
            "\tc.* ,\n" +
            "\tp.pic_url,\n" +
            "\tp.`name`\n" +
            "FROM\n" +
            "\t`comment` c,\n" +
            "\torder_info o,\n" +
            "\tproject p \n" +
            "WHERE\n" +
            "\tp.id = o.project_id \n" +
            "\tAND o.id = c.service_id\n" +
            "\tand o.open_id =  #{openid}")
    List<CommentBo> getByOpenid(String openid);
	
}
