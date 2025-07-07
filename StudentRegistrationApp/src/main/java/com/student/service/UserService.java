package com.student.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.student.model.User;

public interface UserService extends UserDetailsService {
    void save(User user);
    User findByUsername(String username);
}