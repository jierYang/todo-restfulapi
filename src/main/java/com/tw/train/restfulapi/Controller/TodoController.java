package com.tw.train.restfulapi.Controller;

import com.tw.train.restfulapi.Controller.Exception.NotFoundException;
import com.tw.train.restfulapi.Service.TodoService;
import com.tw.train.restfulapi.modal.Todo;
import com.tw.train.restfulapi.modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
    public Page<Todo> getTodoList(Pageable pageable){
        return todoService.getTodoList(pageable);
    }

//    @GetMapping
//    public Page<Todo> getTodoListByAction(String action,Pageable pageable){
//        return todoService.getTodoListByAction(action,pageable);
//    }

    @GetMapping(value = "/{id}")
    public Todo getToDoById(@PathVariable(value = "id") Long id){
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //全局变量，service中也可以拿到
        System.out.println(user);
        return todoService.getTodoById(id);
    }

    @PostMapping
    public HttpStatus createTodo(@RequestBody Todo todo){
        //todo.setuser
        return todoService.createTodo(todo)?HttpStatus.OK:HttpStatus.EXPECTATION_FAILED;
    }

    @DeleteMapping("/{id}")
    public List<Todo> deleteTodo(@PathVariable(value = "id") Long id) throws NotFoundException {
        if (todoService.getTodoById(id) == null) {
            throw new NotFoundException();
        }
        return todoService.deleteTodo(id);
    }

    @PutMapping
    public Todo updateTodo(@RequestBody Todo todo) throws NotFoundException {
        if (todoService.getTodoById(todo.getId()) == null) {
            throw new NotFoundException();
        }
        return todoService.UpdateTodo(todo);
    }

//    @GetMapping(value = "/page/{page}/size/{size}")
//    public Page<Todo> getPageSize(@PathVariable(value = "page") Integer page, @PathVariable(value = "size") Integer size){
//        return todoService.getPageSize(page,size);
//    }
}
