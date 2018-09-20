package com.tw.train.restfulapi.Service;

import com.tw.train.restfulapi.modal.Todo;
import com.tw.train.restfulapi.modal.User;
import com.tw.train.restfulapi.repository.TodoRepository;
import com.tw.train.restfulapi.repository.UserRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepostiory userRepository;

    public User registerUser(User user) {
        User user1 = userRepository.save(user);
        return userRepository.save(user);
    }
}
