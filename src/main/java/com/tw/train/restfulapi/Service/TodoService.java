package com.tw.train.restfulapi.Service;

import com.tw.train.restfulapi.modal.Todo;
import com.tw.train.restfulapi.modal.User;
import com.tw.train.restfulapi.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    private List<Todo> todoList = new ArrayList<>();

    public Page<Todo> getTodoList(Pageable pageable) {
        User user = getPrincipal();

        return todoRepository.findAllByUserid(user.getId(), pageable);
    }

    private User getPrincipal() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public Todo getTodoById(Long id) {
        User user = getPrincipal();
        return todoRepository.findOneByUseridAndId(user.getId(), id);
    }

    public Todo createTodo(Todo todo) {
        User user = getPrincipal();
        todo.setUserid(user.getId());
        return todoRepository.save(todo);
//        return todoRepository.save(todo) != null;
    }

    public Boolean deleteTodo(Long id) {
        if (getTodoById(id) == null) {
            return false;
        }

        User user = getPrincipal();

        todoRepository.deleteByUseridAndId(user.getId(),id);
        return true;
    }

    public Todo UpdateTodo(Todo todo) {
        User user = getPrincipal();

        return todoRepository.existsByUseridAndId(user.getId(),todo.getId()) ? todoRepository.save(todo) : null;
    }
}
