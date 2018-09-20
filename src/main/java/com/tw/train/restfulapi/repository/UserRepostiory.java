package com.tw.train.restfulapi.repository;


import com.tw.train.restfulapi.modal.User;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepostiory  extends JpaRepository<User, Long> {
    User findByNameAndPassword(String name, String password);

    User findByName(String name);
}
