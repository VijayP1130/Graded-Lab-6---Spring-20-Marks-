package com.student.service;

import java.util.List;

import com.student.model.Student;

public interface StudentService {
    void save(Student student);
    void update(Student student);
    void delete(Long id);
    Student findById(Long id);
    List<Student> findAll();
    List<Student> findByCourse(String course);
}