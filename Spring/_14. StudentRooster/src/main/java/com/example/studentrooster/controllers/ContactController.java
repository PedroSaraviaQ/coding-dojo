package com.example.studentrooster.controllers;

import com.example.studentrooster.models.Contact;
import com.example.studentrooster.models.Student;
import com.example.studentrooster.repositories.ContactRepository;
import com.example.studentrooster.repositories.StudentRepository;
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
@RequestMapping("/contacts")
public class ContactController {
    @Autowired ContactRepository contactRepository;
    @Autowired StudentRepository studentRepository;
    
    @GetMapping("/new")
    public String newContact(@ModelAttribute("contact") Contact contact, Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "newContact.jsp";
    }
    
    @PostMapping("/new")
    public String createStudent(@Valid @ModelAttribute Contact contact, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return newContact(contact, model);
        }
        contactRepository.save(contact);
        return "redirect:/students";
    }
}
