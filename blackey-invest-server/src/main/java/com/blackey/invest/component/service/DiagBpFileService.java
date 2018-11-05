package com.blackey.invest.component.service;

import com.blackey.mybatis.service.BaseService;
import com.blackey.mybatis.utils.PageUtils;
import com.blackey.invest.component.domain.DiagBpFile;

import java.util.Map;

/**
 * 上传bp文件信息 DiagBpFileService
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
public interface DiagBpFileService extends BaseService<DiagBpFile> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);
}

