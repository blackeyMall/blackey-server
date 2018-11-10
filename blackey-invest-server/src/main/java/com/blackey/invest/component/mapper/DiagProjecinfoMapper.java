package com.blackey.invest.component.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.invest.component.domain.DiagProjecinfo;
import com.blackey.invest.dto.bo.DiagProjecinfoBo;
import com.blackey.mybatis.dao.BaseDAO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 项目信息表 DiagProjecinfoMapper
 * 
 * @author kaven
 * @date 2018-11-05 10:02:16
 */

public interface DiagProjecinfoMapper extends BaseDAO<DiagProjecinfo> {


    List<DiagProjecinfoBo> getProjectsPage(@Param("projectNo")String projectNo, Page page);
}
