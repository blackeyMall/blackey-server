package com.blackey.component.repository;

import com.blackey.component.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

/**
 * 用户repository
 *
 * @author : blackey
 * @date : 2018/10/29
 */
@Component
public interface UserRepository extends JpaRepository<User,String>,JpaSpecificationExecutor{
}
