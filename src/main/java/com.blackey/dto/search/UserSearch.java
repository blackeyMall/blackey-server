package com.blackey.dto.search;

import com.blackey.component.model.User;
import com.blackey.component.spec.UserSpec;
import com.blackey.jpa.common.BaseSearch;
import org.springframework.data.jpa.domain.Specification;

/**
 * 用户
 *
 * @author : blackey
 * @date : 2018/10/29
 */
public class UserSearch extends BaseSearch<User> {


    @Override
    public Specification<User> getSpecification() {
        return new UserSpec(this);
    }


}
