package com.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.dao.UserDAO;
import com.student.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDAO userDAO;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.save(user);
    }
    
    @Override
    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return user;
    }
}