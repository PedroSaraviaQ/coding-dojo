package com.example.dojosandninjas.controllers;

import com.example.dojosandninjas.models.Dojo;
import com.example.dojosandninjas.services.DojoService;
import com.example.dojosandninjas.services.NinjaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dojos")
public class DojoController {
    @Autowired private DojoService dojoService;
    @Autowired private NinjaService ninjaService;

    @GetMapping("")
    public String index(Model model) {
        List<Dojo> dojos = dojoService.findAll();
        model.addAttribute("dojos", dojos);
        return "showDojos.jsp";
    }

    @GetMapping("/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
        return "createDojo.jsp";
    }

    @PostMapping("/new")
    public String createDojo(@Valid @ModelAttribute Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return newDojo(dojo);
        }
        dojoService.save(dojo);
        return "redirect:/dojos";
    }

    @GetMapping("/{id}")
    public String showDojo(@PathVariable Long id, Model model) {
        Dojo dojo = dojoService.findById(id);
        model.addAttribute("dojo", dojo);
        return "dojo.jsp";
    }
}
