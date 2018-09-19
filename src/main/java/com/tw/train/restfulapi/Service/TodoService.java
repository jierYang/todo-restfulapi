package com.tw.train.restfulapi.Service;

import com.tw.train.restfulapi.modal.Todo;
import com.tw.train.restfulapi.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    private List<Todo> todoList = new ArrayList<>();

    public TodoService() {
        todoList.add(new Todo(1L, "meeting", "To Do", new Date(), "Learning DevOps"));
        todoList.add(new Todo(2L, "meeting with LY", "To Do", new Date(), "Learning DevOps"));
        todoList.add(new Todo(3L, "learn", "In progress", new Date(), "Learning DevOps"));
        todoList.add(new Todo(4L, "preparation", "Finished", new Date(), "Learning DevOps"));
    }

    public List<Todo> getTodoList() {
        return todoRepository.findAll();
    }

    public Todo getTodoById(Long id) {
//        return todoList.stream().filter(n -> n.getId().equals(id)).findFirst().get();
        return todoRepository.getOne(id);
    }

    public Todo createTodo(Todo todo) {
//        todo.setId(todoList.get(todoList.size() - 1).getId() + 1L);
//        todoList.add(todo);
//        return todo;
        return todoRepository.save(todo);
    }

    public List<Todo> deleteTodo(Long id) {

//        Todo todo = todoList.stream().filter(n -> n.getId().equals(id)).findFirst().get();
//        todoList.remove(todo);
//        return todoList;
////          todoList = todoList.stream().filter(item -> !item.getId().equals(id)).collect(Collectors.toList());
        todoRepository.delete(id);
        return todoRepository.findAll();
    }

    public Todo UpdateTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Page<Todo> getPageSize(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page-1,size);
//        Page<Todo> result = todoRepository.findAll(pageable);
//        return result.getContent();
        return todoRepository.findAll(pageable);
    }
}
