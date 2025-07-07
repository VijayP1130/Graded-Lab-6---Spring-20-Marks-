package com.student.dao;

import com.student.model.User;

public interface UserDAO {
    User findByUsername(String username);
    void save(User user);
}