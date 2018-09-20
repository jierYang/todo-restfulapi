package com.tw.train.restfulapi.Service;

import com.tw.train.restfulapi.modal.Status;
import com.tw.train.restfulapi.modal.Todo;
import com.tw.train.restfulapi.modal.User;
import com.tw.train.restfulapi.repository.TodoRepository;
import com.tw.train.restfulapi.repository.UserRepostiory;
import com.tw.train.restfulapi.session.SessionStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepostiory userRepository;

    @Autowired
    private SessionStore sessionStore;

    public HttpStatus registerUser(User user) {
        User result = userRepository.save(user);
        return result == null ? HttpStatus.EXPECTATION_FAILED : HttpStatus.OK;
    }

    public String loginUser(User user) {
        User result = userRepository.findByName(user.getName());

        return result.getPassword().equals(user.getPassword()) ? sessionStore.createSession(result) : HttpStatus.UNAUTHORIZED.toString();
    }
}
