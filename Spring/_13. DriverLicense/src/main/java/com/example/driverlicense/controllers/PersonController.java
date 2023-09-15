package com.example.driverlicense.controllers;

import com.example.driverlicense.models.Person;
import com.example.driverlicense.services.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/persons")
public class PersonController {
    @Autowired PersonService personService;

    @GetMapping("")
    public String index(Model model) {
        List<Person> persons = personService.findAll();
        model.addAttribute("persons", persons);
        return "index.jsp";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "createPerson.jsp";
    }

    @PostMapping("/new")
    public String createPerson(@Valid @ModelAttribute Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "createPerson.jsp";
        }
        personService.save(person);
        return "redirect:/persons";
    }

    @GetMapping("/{id}")
    public String showPerson(@PathVariable Long id, Model model) {
        Person person = personService.findById(id);
        model.addAttribute("person", person);
        return "showPerson.jsp";
    }
}
