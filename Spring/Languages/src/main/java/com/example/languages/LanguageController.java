package com.example.languages;

import org.springframework.stereotype.Controller;

@Controller
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }
}
