package com.example.languages;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/languages")
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("")
    public String index(Model model, @ModelAttribute("language") Language language) {
        List<Language> languages = languageService.findAll();
        model.addAttribute("languages", languages);
        return "home.jsp";
    }

    @PostMapping("")
    public String create(Model model, @Valid @ModelAttribute Language language, BindingResult result) {
        if (result.hasErrors()) {
            return index(model, language);
        }
        languageService.save(language);
        return "redirect:/languages";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model) {
        Language language = languageService.findById(id);
        model.addAttribute("language", language);
        return "language.jsp";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Language language = languageService.findById(id);
        model.addAttribute("language", language);
        return "edit.jsp";
    }

    @PutMapping("/{id}")
    public String update(@Valid @ModelAttribute Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        }
        languageService.save(language);
        return "redirect:/languages";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        languageService.deleteById(id);
        return "redirect:/languages";
    }
}
