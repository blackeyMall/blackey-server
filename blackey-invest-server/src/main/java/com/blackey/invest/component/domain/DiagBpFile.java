package com.blackey.invest.component.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blackey.mybatis.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 上传bp文件信息
 *
 * @author kaven
 * @date 2018-11-05 10:02:15
 */
@Getter
@Setter
@TableName("diag_bp_file")
public class DiagBpFile extends BaseModel<DiagBpFile> implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 文件名称
	 */
	private String fileName;
	/**
	 * 文件路径
	 */
	private String filePath;
	/**
	 * 项目编号
	 */
	private String projectNo;


    @Override
    protected Serializable pkVal() {
        return this.getId();
    }
                                    

}
