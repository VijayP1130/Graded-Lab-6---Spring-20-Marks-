package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.dao.StudentDAO;
import com.student.model.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    private StudentDAO studentDAO;
    
    @Override
    public void save(Student student) {
        studentDAO.save(student);
    }
    
    @Override
    public void update(Student student) {
        studentDAO.update(student);
    }
    
    @Override
    public void delete(Long id) {
        studentDAO.delete(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Student findById(Long id) {
        return studentDAO.findById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return studentDAO.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Student> findByCourse(String course) {
        return studentDAO.findByCourse(course);
    }
}