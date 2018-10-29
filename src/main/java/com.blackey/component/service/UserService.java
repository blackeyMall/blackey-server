package com.blackey.component.service;

import com.blackey.component.model.User;
import com.blackey.dto.form.UserForm;

/**
 * 用户service
 *
 * @author : blackey
 * @date : 2018/10/29
 */
public interface UserService {


    /**
     * 查询单条
     * @return
     */
    void save(UserForm form);
}
