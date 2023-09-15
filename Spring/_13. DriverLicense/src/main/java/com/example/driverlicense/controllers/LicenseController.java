package com.example.driverlicense.controllers;

import com.example.driverlicense.models.License;
import com.example.driverlicense.models.Person;
import com.example.driverlicense.services.LicenseService;
import com.example.driverlicense.services.PersonService;
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
@RequestMapping("/licenses")
public class LicenseController {
    @Autowired LicenseService licenseService;
    @Autowired PersonService personService;

    @GetMapping("/new")
    public String newLicense(@ModelAttribute("license") License license, Model model) {
        List<Person> persons = personService.findAll();
        model.addAttribute("persons", persons);
        return "createLicense.jsp";
    }

    @PostMapping("/new")
    public String createLicense(@Valid @ModelAttribute License license, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return newLicense(license, model);
        }
        licenseService.save(license);
        return "redirect:/persons";
    }
}
