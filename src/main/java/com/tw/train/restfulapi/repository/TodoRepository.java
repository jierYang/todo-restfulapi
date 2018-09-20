package com.tw.train.restfulapi.repository;

import com.tw.train.restfulapi.modal.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    //List<Todo>
    Page<Todo> findAllByAction(String action, Pageable pageable);
//
//    List<Todo> findALlByActionDesc();
//
//    List<Todo> findAllrByActionAsc();
}
