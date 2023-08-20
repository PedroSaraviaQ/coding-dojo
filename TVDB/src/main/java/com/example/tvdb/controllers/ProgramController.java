package com.example.tvdb.controllers;

import com.example.tvdb.models.Program;
import com.example.tvdb.services.ProgramService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/programas")
public class ProgramController {
    private final ProgramService programService;

    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping("")
    public String showPrograms(Model model, HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            return "redirect:/";
        }
        List<Program> programs = programService.findAll();
        model.addAttribute("programs", programs);
        return "programs.jsp";
    }

    @GetMapping("/nuevo")
    public String newProgram(@ModelAttribute Program program, HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            return "redirect:/";
        }
        return "newProgram.jsp";
    }

    @PostMapping("/nuevo")
    public String createProgram(@Valid @ModelAttribute Program program, BindingResult result, Model model) {
        boolean matchError = programService.existsByTitle(program.getTitle());
        if (matchError) {
            model.addAttribute("matchError", "El título ya existe");
        }
        if (result.hasErrors() || matchError) {
            return "newProgram.jsp";
        }
        programService.save(program);
        return "redirect:/programas";
    }
}
