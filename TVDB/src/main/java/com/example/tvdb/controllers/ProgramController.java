package com.example.tvdb.controllers;

import com.example.tvdb.models.Program;
import com.example.tvdb.services.ProgramService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        return "allPrograms.jsp";
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

    @GetMapping("/{id}")
    public String showProgram(@PathVariable Long id, Model model, HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            return "redirect:/";
        }
        Program program = programService.findById(id);
        model.addAttribute("program", program);
        return "showProgram.jsp";
    }

    @GetMapping("/{id}/editar")
    public String editProgram(@PathVariable Long id, Model model, HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            return "redirect:/";
        }
        Program programToEdit = programService.findById(id);
        model.addAttribute("program", programToEdit);
        return "editProgram.jsp";
    }

    @PutMapping("/{id}/editar")
    public String updateProgram(@Valid @ModelAttribute Program program, BindingResult result, Model model) {
        boolean matchError = programService.existsByTitle(program.getTitle());
        if (matchError) {
            model.addAttribute("matchError", "El título ya existe");
        }
        if (result.hasErrors() || matchError) {
            return "editProgram.jsp";
        }
        programService.save(program);
        return "redirect:/programas";
    }

    @DeleteMapping("/{id}/eliminar")
    public String deleteProgram(@PathVariable Long id) {
        programService.deleteById(id);
        return "redirect:/programas";
    }
}
