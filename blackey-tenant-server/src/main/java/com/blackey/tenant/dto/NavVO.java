package com.blackey.tenant.dto;

import com.blackey.tenant.component.domain.SysMenuEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * 导航菜单及用户权限
 * @author wangwei  by Kaven
 * @date : 2018/6/5
 */
@Setter
@Getter
public class NavVO implements Serializable {

    private static final long serialVersionUID = 1L;


    private List<SysMenuEntity> menuList;
    private Set<String> permissions ;


}
