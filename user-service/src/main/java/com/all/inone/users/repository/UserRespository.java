package com.all.inone.users.repository;

import com.all.inone.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User, Long> {

    User findUserByUserId(Long id);

}
