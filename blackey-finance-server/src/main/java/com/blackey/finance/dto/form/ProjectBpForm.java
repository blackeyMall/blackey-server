package com.blackey.finance.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 项目bp信息 Form表单
 * 
 * @author kaven
 * @date 2018-12-07 09:40:20
 */
@Getter
@Setter
public class ProjectBpForm implements Serializable {

    private static final long serialVersionUID = 1L;

    private String projedtId;
	/**
	 * 附件地址
	 */
	private String attachment;


}
