package com.example.tvdb.controllers;

import com.example.tvdb.models.User;
import com.example.tvdb.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model, @ModelAttribute User user) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "home.jsp";
    }

    @PostMapping("/")
    public String create(@Valid @ModelAttribute User user, BindingResult result, Model model) {
        boolean matchError = !user.getPassword().equals(user.getPasswordConfirmation());
        if (matchError) {
            model.addAttribute("matchError", "Las contraseñas no coinciden");
        }
        if (result.hasErrors() || matchError) {
            return "home.jsp";
        }
        userService.save(user);
        return "redirect:/";
    }
}
