package com.tw.train.restfulapi.Service;

import com.tw.train.restfulapi.modal.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private List<Todo> todoList = new ArrayList<>();

    public TodoService() {
        todoList.add(new Todo(1L, "meeting", "To Do", new Date(), "Learning DevOps"));
        todoList.add(new Todo(2L, "meeting with LY", "To Do", new Date(), "Learning DevOps"));
        todoList.add(new Todo(3L, "learn", "In progress", new Date(), "Learning DevOps"));
        todoList.add(new Todo(4L, "preparation", "Finished", new Date(), "Learning DevOps"));
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public Todo getTodoById(Long id) {
        return todoList.stream().filter(n -> n.getId().equals(id)).findFirst().get();
    }

    public Todo createTodo(Todo todo) {
        todo.setId(todoList.get(todoList.size() - 1).getId() + 1L);
        todoList.add(todo);
        return todo;
    }

    public List<Todo> deleteTodo(Long id) {

        Todo todo = todoList.stream().filter(n -> n.getId().equals(id)).findFirst().get();
        todoList.remove(todo);
        return todoList;
//          todoList = todoList.stream().filter(item -> !item.getId().equals(id)).collect(Collectors.toList());
    }
}
