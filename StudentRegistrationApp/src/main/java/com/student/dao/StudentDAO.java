package com.student.dao;

import java.util.List;

import com.student.model.Student;

public interface StudentDAO {
    void save(Student student);
    void update(Student student);
    void delete(Long id);
    Student findById(Long id);
    List<Student> findAll();
    List<Student> findByCourse(String course);
}