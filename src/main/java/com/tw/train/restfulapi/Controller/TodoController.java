package com.tw.train.restfulapi.Controller;

import com.tw.train.restfulapi.Controller.Exception.AuthorizedException;
import com.tw.train.restfulapi.Controller.Exception.NotFoundException;
import com.tw.train.restfulapi.Service.TodoService;
import com.tw.train.restfulapi.modal.Todo;
import com.tw.train.restfulapi.modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;

@RestController
@RequestMapping(value = "/todos")
public class TodoController {
//    private TodoService todoService = new TodoService();

    @Autowired
    private TodoService todoService;

    @GetMapping
    public Page<Todo> getTodoList(Pageable pageable) {
        return todoService.getTodoList(pageable);
    }

    @GetMapping(value = "/{id}")
    public Todo getToDoById(@PathVariable(value = "id") Long id) throws AuthorizedException {
        Todo todo = todoService.getTodoById(id);

        if (todo == null) {
            throw new AuthorizedException();
        }
        return todo;
    }

    @GetMapping(value = "/search/{action}")
    public Page<Todo> serachToDoByAction(@PathVariable(value = "action") String action,Pageable pageable) {
        return todoService.serachToDoByAction("%"+action+"%",pageable);
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
//        return todoService.createTodo(todo) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTodo(@PathVariable(value = "id") Long id) {
        return todoService.deleteTodo(id) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable(value = "id") Long id, @RequestBody Todo todo) throws AuthorizedException {
        Todo result = todoService.UpdateTodo(todo);
        if (result == null) {
            throw new AuthorizedException();
        }
        return result;
    }
}
