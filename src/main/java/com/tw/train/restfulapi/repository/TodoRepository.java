package com.tw.train.restfulapi.repository;

import com.tw.train.restfulapi.modal.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;


@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    Page<Todo> findAllByUserid(Long userid,Pageable pageable);

//    Todo getOneByUserid(Long userid,Long todoid);

    Todo findOneByUseridAndId(Long userid, Long todoid);

    @Transactional
    void deleteByUseridAndId(Long userid, Long todoid);

    Boolean existsByUseridAndId(Long userid, Long todoid);

    Page<Todo> findAllByUseridAndActionLike (Long userid,String name,Pageable pageable);
}
