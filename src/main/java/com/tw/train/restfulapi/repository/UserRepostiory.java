package com.tw.train.restfulapi.repository;

import com.tw.train.restfulapi.modal.Todo;
import com.tw.train.restfulapi.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepostiory  extends JpaRepository<User, Long> {
}
