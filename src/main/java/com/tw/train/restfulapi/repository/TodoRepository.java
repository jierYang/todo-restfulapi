package com.tw.train.restfulapi.repository;

import com.tw.train.restfulapi.modal.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import org.springframework.data.domain.Pageable;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    Page<Todo> findAllByUserid(Long userid,Pageable pageable);
}
