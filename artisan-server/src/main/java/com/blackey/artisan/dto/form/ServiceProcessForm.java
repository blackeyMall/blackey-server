package com.blackey.artisan.dto.form;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackey.artisan.global.constants.PicTypeStatus;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *  Form表单
 * 
 * @author kavenW
 * @date 2018-11-06 23:04:13
 */
@Getter
@Setter
public class ServiceProcessForm extends Page {

    private static final long serialVersionUID = 1L;


    private String content;

	private String orderId;


	private List<String> picUrls;


}
