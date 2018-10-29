package com.blackey.component.spec;

import com.blackey.component.model.User;
import com.blackey.dto.search.UserSearch;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * 用户
 *
 * @author : blackey
 * @date : 2018/10/29
 */
public class UserSpec implements Specification<User>{

    private UserSearch search;

    public UserSpec(UserSearch search) {
        this.search = search;
    }

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {



        return null;
    }
}
