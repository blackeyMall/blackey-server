package com.blackey.admin.dto;

import com.blackey.admin.component.domain.SysMenuEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * 导航菜单及用户权限
 * Created by Kaven
 * Date: 2018/6/5
 */
@Setter
@Getter
public class NavVO implements Serializable {

    private static final long serialVersionUID = 1L;


    private List<SysMenuEntity> menuList;
    private Set<String> permissions ;

}
