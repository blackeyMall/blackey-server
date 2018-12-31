package com.blackey.tenant.dto.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 租户菜单关联form
 * @author : kaven
 *
 * @date: 2018/12/25 13:52
 **/
@Getter
@Setter
public class SysTenantMenuForm implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 租户id
     */
    private Long tenantId;
    /**
     * 菜单id列表
     */
    private List<Long> menuIdList;


}
