package com.student.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public User findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        return (User) session.createQuery("FROM User WHERE username = :username")
                .setParameter("username", username)
                .uniqueResult();
    }
    
    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }
}