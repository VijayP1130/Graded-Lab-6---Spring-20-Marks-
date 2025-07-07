package com.student.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void save(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }
    
    @Override
    public void update(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.update(student);
    }
    
    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id);
        if (student != null) {
            session.delete(student);
        }
    }
    
    @Override
    public Student findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<Student> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Student ORDER BY studentId").list();
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<Student> findByCourse(String course) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Student WHERE course = :course")
                .setParameter("course", course)
                .list();
    }
}