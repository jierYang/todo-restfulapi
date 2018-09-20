package com.tw.train.restfulapi.session;

import com.tw.train.restfulapi.modal.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class SessionStore {
    private Map<String, User> userSessions;

    public SessionStore() {
        userSessions = new HashMap<>();
    }

    public String createSession(User user) {
        String sessionId = UUID.randomUUID().toString();
        userSessions.put(sessionId, user);
        return sessionId;
    }

//    public Map<String, User> getUserSessions() {
//        return userSessions;
//    }
}
