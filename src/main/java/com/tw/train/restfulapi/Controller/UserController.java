package com.tw.train.restfulapi.Controller;

import com.tw.train.restfulapi.Service.UserService;
import com.tw.train.restfulapi.modal.Status;
import com.tw.train.restfulapi.modal.Todo;
import com.tw.train.restfulapi.modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "register")
    public HttpStatus RegisterUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @PostMapping(value = "/login")
    public String LoginUser(@RequestBody User user){
        return userService.loginUser(user);
    }
}
