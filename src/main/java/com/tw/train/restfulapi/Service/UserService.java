package com.tw.train.restfulapi.Service;

import com.tw.train.restfulapi.modal.Status;
import com.tw.train.restfulapi.modal.Todo;
import com.tw.train.restfulapi.modal.User;
import com.tw.train.restfulapi.repository.TodoRepository;
import com.tw.train.restfulapi.repository.UserRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepostiory userRepository;

    public HttpStatus registerUser(User user) {
        User result = userRepository.save(user);
       return result==null? HttpStatus.EXPECTATION_FAILED:HttpStatus.OK;
    }

    public HttpStatus loginUser(User user) {
//        User result= userRepository.findByNameAndPassword(user.getName(),user.getPassword());
//        return result!=null?HttpStatus.OK:HttpStatus.UNAUTHORIZED;
        User result = userRepository.findByName(user.getName());
        return result.getPassword().equals(user.getPassword())?HttpStatus.OK:HttpStatus.UNAUTHORIZED;
    }
}
