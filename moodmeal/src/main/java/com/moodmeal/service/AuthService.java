package com.moodmeal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moodmeal.model.User;
import com.moodmeal.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public String register(User user) {

        if (user.getEmail() == null || user.getPassword() == null) {
            return "Registration failed: email and password are required";
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            return "Registration failed: an account with this email already exists";
        }

        userRepository.save(user);

        return "Registration successful";
    }

    public String login(User user) {

        User existing = userRepository.findByEmail(user.getEmail()).orElse(null);

        if (existing == null ||
            !existing.getPassword().equals(user.getPassword())) {
            return "Login failed: invalid email or password";
        }

        return "Login successful";
    }
}
