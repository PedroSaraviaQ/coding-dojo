package com.example.studentrooster.controllers;

import com.example.studentrooster.models.Dorm;
import com.example.studentrooster.models.Student;
import com.example.studentrooster.services.DormService;
import com.example.studentrooster.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dorms")
public class DormController {
    @Autowired DormService dormService;
    @Autowired StudentService studentService;
    
    @GetMapping("")
    public String index(Model model) {
        List<Dorm> dorms = dormService.findAll();
        model.addAttribute("dorms", dorms);
        return "allDorms.jsp";
    }
    
    @GetMapping("/new")
    public String newDorm(@ModelAttribute("dorm") Dorm dorm) {
        return "newDorm.jsp";
    }
    
    @PostMapping("/new")
    public String createDorm(@Valid @ModelAttribute Dorm dorm, BindingResult result) {
        if (result.hasErrors()) {
            return "newDorm.jsp";
        }
        dormService.save(dorm);
        return "redirect:/dorms/" + dorm.getId();
    }
    
    @GetMapping("/{id}")
    public String showDorm(@PathVariable Long id, Model model) {
        Dorm dorm = dormService.findById(id);
        List<Student> students = studentService.findAll();
        model.addAttribute("dorm", dorm);
        model.addAttribute("students", students);
        return "showDorm.jsp";
    }
    
    @PutMapping("/{id}/students")
    public String updateStudents(@PathVariable("id") Long dormId, @RequestParam Long studentId) {
        Dorm dorm = dormService.findById(dormId);
        Student student = studentService.findById(studentId);
        student.setDorm(dorm);
        studentService.save(student);
        return "redirect:/dorms/" + dormId;
    }
    
    @DeleteMapping("/{id}/students")
    public String deleteStudents(@PathVariable("id") Long dormId, @RequestParam Long studentId) {
        Student student = studentService.findById(studentId);
        student.setDorm(null);
        studentService.save(student);
        return "redirect:/dorms/" + dormId;
    }
}
