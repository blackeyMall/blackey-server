package com.blackey.finance.component.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.finance.component.domain.ProjectInfo;
import com.blackey.finance.dto.bo.ProjectInfoBo;
import com.blackey.finance.dto.form.ProjectInfoForm;
import com.blackey.mybatis.dao.BaseDAO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 项目信息表 ProjectInfoMapper
 * 
 * @author kaven
 * @date 2018-12-07 09:40:20
 */

public interface ProjectInfoMapper extends BaseDAO<ProjectInfo> {

    /**
     * 分页查询
     * @param form
     * @param page
     * @return
     */
    @Select("<script>" +
            "SELECT * FROM t_project_info p WHERE 1=1 " +
            "<if test=\"form.openId != '' and form.openId != null\">" +
            " and p.open_id = #{form.openId}\n" +
            "</if>" +
            "<if test=\"form.orderbyEnum.value == 'FOLLOWNUM' \">\n" +
            " order by p.follow_num desc \n" +
            "</if>" +
            "<if test=\"form.orderbyEnum.value == 'LIKENUM' \">\n" +
            " order by p.like_num desc \n" +
            "</if>" +
            "<if test=\"form.orderbyEnum.value == 'DEFAULT' or form.orderbyEnum.value == '' \">\n" +
            " order by p.created_date desc \n" +
            "</if>" +
            "</script>")
    List<ProjectInfoBo> queryPage(@Param("form") ProjectInfoForm form, Page<ProjectInfoBo> page);
}
