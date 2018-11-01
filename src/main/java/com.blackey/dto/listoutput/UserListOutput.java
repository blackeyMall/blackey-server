package com.blackey.dto.listoutput;

import com.blackey.component.model.User;
import com.blackey.dto.bo.UserBo;
import com.blackey.jpa.common.BaseListOutput;

/**
 * 用户对象输出
 *
 * @author blackey
 * @date 2018/11/1
 */
public class UserListOutput extends BaseListOutput<User,UserBo>{

    public UserListOutput(Object from) {
        super(from);
    }
}
