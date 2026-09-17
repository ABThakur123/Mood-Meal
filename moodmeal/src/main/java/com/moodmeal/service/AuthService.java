package com.moodmeal.service;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.moodmeal.model.User;

@Service
public class AuthService {

    private final ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();

    public String register(User user) {

        if (user.getEmail() == null || user.getPassword() == null) {
            return "Registration failed: email and password are required";
        }

        if (users.containsKey(user.getEmail())) {
            return "Registration failed: an account with this email already exists";
        }

        users.put(user.getEmail(), user);

        return "Registration successful";
    }

    public String login(User user) {

        User existing = users.get(user.getEmail());

        if (existing == null ||
            !existing.getPassword().equals(user.getPassword())) {
            return "Login failed: invalid email or password";
        }

        return "Login successful";
    }
}
