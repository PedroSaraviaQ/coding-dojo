package com.example.dojosurvey;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Form {
    @GetMapping("/")
    public String index() {
        return "form.jsp";
    }

    @PostMapping("/")
    public String form(
            @RequestParam String name, @RequestParam String location, @RequestParam String language,
            @RequestParam String comment, HttpSession session
    ) {
        if (name.isEmpty() || location.isEmpty() || language.isEmpty()) {
            return "redirect:/";
        } else if (language.equals("Java")) {
            return "java.jsp";
        } else {
            session.setAttribute("name", name);
            session.setAttribute("location", location);
            session.setAttribute("language", language);
            session.setAttribute("comment", comment);
            return "redirect:/result";
        }
    }

    @GetMapping("/result")
    public String result() {
        return "result.jsp";
    }

    @PostMapping("/result")
    public String goBack() {
        return "redirect:/";
    }
}
