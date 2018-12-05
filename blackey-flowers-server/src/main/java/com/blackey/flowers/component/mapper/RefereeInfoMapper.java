package com.blackey.flowers.component.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.flowers.component.domain.RefereeInfo;
import com.blackey.flowers.dto.bo.RefereeInfoBo;
import com.blackey.flowers.dto.form.RefereeInfoForm;
import com.blackey.mybatis.dao.BaseDAO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 *  RefereeInfoMapper
 * 
 * @author kaven
 * @date 2018-11-28 20:43:34
 */

public interface RefereeInfoMapper extends BaseDAO<RefereeInfo> {

    /**
     * 分页查询
     * @param refereeInfoForm
     * @param page
     * @return
     */
    @Select("<script>SELECT * FROM t_referee_info r " +
            "where 1=1 " +
            "<if test=\"form.name != '' and form.name != null\">" +
            " and r.name = #{form.name}\n" +
            "</if>" +
            "<if test=\"form.channel != '' and form.channel != null\">" +
            " and r.channel = #{form.channel}\n" +
            "</if>" +
            " order by r.created_date desc "+
            "</script>")
    List<RefereeInfoBo> queryPage(@Param("form") RefereeInfoForm refereeInfoForm, Page<RefereeInfoBo> page);
}
