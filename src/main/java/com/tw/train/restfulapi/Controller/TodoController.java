package com.tw.train.restfulapi.Controller;

import com.tw.train.restfulapi.Service.TodoService;
import com.tw.train.restfulapi.modal.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/todos")
public class TodoController {
//    private TodoService todoService = new TodoService();

    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<List<Todo>> getTodoList() throws IOException {
        return todoService.getTodoList();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Todo> getToDoById(@PathVariable(value = "id") Long id) throws IOException{
        return todoService.getTodoById(id);
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo){
        return todoService.createTodo(todo);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<Todo>> deleteTodo(@PathVariable(value = "id") Long id){
        return todoService.deleteTodo(id);
    }
}
