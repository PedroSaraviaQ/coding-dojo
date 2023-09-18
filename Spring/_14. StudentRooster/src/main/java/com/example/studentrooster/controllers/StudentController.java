package com.example.studentrooster.controllers;

import com.example.studentrooster.models.Student;
import com.example.studentrooster.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired StudentService studentService;
    
    @GetMapping("")
    public String index(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "index.jsp";
    }
    
    @GetMapping("/new")
    public String newStudent(@ModelAttribute("student") Student student) {
        return "newStudent.jsp";
    }
    
    @PostMapping("/new")
    public String createStudent(@Valid @ModelAttribute Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "newStudent.jsp";
        }
        studentService.save(student);
        return "redirect:/students";
    }
}
