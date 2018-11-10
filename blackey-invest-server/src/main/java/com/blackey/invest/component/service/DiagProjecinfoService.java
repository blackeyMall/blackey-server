package com.blackey.invest.component.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.invest.dto.bo.DiagProjecinfoBo;
import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.invest.component.domain.DiagProjecinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 项目信息表 DiagProjecinfoService
 *
 * @author kaven
 * @date 2018-11-05 10:02:16
 */
public interface DiagProjecinfoService extends BaseService<DiagProjecinfo> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);

    List<DiagProjecinfoBo> getProjectsPage(@Param("projectNo")String projectNo,Page page);
}

