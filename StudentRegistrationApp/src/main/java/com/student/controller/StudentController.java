package com.student.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.student.model.Student;
import com.student.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    @GetMapping("/list")
    public String listStudents(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "student/list";
    }
    
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/form";
    }
    
    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String editStudent(@PathVariable Long id, Model model) {
        Student student = studentService.findById(id);
        if (student == null) {
            return "redirect:/students/list";
        }
        model.addAttribute("student", student);
        return "student/form";
    }
    
    @PostMapping("/save")
    public String saveStudent(@Valid @ModelAttribute Student student, 
                             BindingResult result, 
                             RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "student/form";
        }
        
        try {
            if (student.getStudentId() == null) {
                studentService.save(student);
                redirectAttributes.addFlashAttribute("successMessage", "Student registered successfully!");
            } else {
                studentService.update(student);
                redirectAttributes.addFlashAttribute("successMessage", "Student updated successfully!");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error occurred: " + e.getMessage());
        }
        
        return "redirect:/students/list";
    }
    
    @GetMapping("/view/{id}")
    public String viewStudent(@PathVariable Long id, Model model) {
        Student student = studentService.findById(id);
        if (student == null) {
            return "redirect:/students/list";
        }
        model.addAttribute("student", student);
        return "student/view";
    }
    
    @PostMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteStudent(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            studentService.delete(id);
            redirectAttributes.addFlashAttribute("successMessage", "Student deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error deleting student: " + e.getMessage());
        }
        return "redirect:/students/list";
    }
    
    @GetMapping("/course/{course}")
    public String listStudentsByCourse(@PathVariable String course, Model model) {
        List<Student> students = studentService.findByCourse(course);
        model.addAttribute("students", students);
        model.addAttribute("course", course);
        return "student/list";
    }
}