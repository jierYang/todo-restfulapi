package com.tw.train.restfulapi.Controller;

import com.tw.train.restfulapi.Controller.Exception.NotFoundException;
import com.tw.train.restfulapi.Service.TodoService;
import com.tw.train.restfulapi.modal.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/todos")
public class TodoController {
//    private TodoService todoService = new TodoService();

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todo> getTodoList(){
        return todoService.getTodoList();
    }

    @GetMapping(value = "/{id}")
    public Todo getToDoById(@PathVariable(value = "id") Long id){
        return todoService.getTodoById(id);
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo){
        return todoService.createTodo(todo);
    }

    @DeleteMapping("/delete/{id}")
    public List<Todo> deleteTodo(@PathVariable(value = "id") Long id) throws NotFoundException {
        if (todoService.getTodoById(id) == null) {
            throw new NotFoundException();
        }
        return todoService.deleteTodo(id);
    }
}
