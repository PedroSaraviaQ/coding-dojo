package com.example.dojosandninjas.controllers;

import com.example.dojosandninjas.models.Dojo;
import com.example.dojosandninjas.models.Ninja;
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
@RequestMapping("/ninjas")
public class NinjaController {
    @Autowired private NinjaService ninjaService;
    @Autowired private DojoService dojoService;

    @GetMapping("")
    public String index(Model model) {
        List<Ninja> ninjas = ninjaService.findAll();
        model.addAttribute("ninjas", ninjas);
        return "showNinjas.jsp";
    }

    @GetMapping("/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
        List<Dojo> dojos = dojoService.findAll();
        model.addAttribute("dojos", dojos);
        return "createNinja.jsp";
    }

    @PostMapping("/new")
    public String createNinja(@Valid @ModelAttribute Ninja ninja, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return newNinja(ninja, model);
        }
        ninjaService.save(ninja);
        return "redirect:/ninjas";
    }
}
