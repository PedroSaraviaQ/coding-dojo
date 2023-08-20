package com.example.tvdb.controllers;

import com.example.tvdb.models.User;
import com.example.tvdb.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(@ModelAttribute User user) {
        return "home.jsp";
    }

    @PostMapping("/")
    public String create(@Valid @ModelAttribute User user, BindingResult result, Model model, HttpSession session) {
        boolean uniqueEmail = userService.existsByEmail(user.getEmail());
        boolean matchError = !user.getPassword().equals(user.getPasswordConfirmation());

        if (uniqueEmail) {
            model.addAttribute("uniqueEmail", "El email ya existe");
        }
        if (matchError) {
            model.addAttribute("matchError", "Las contraseñas no coinciden");
        }
        if (result.hasErrors() || matchError || uniqueEmail) {
            return "home.jsp";
        }

        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        userService.save(user);
        session.setAttribute("currentUser", user);
        return "redirect:/programas";
    }

    @PostMapping("/login")
    public String login(@RequestParam String myEmail, @RequestParam String myPassword, Model model,
                        @ModelAttribute User user, HttpSession session) {
        User myUser = userService.findByEmail(myEmail);

        if (myUser == null) {
            model.addAttribute("userError", "El usuario no existe");
            model.addAttribute("myEmail", myEmail);
            model.addAttribute("myPassword", myPassword);
            return "home.jsp";
        }
        if (!BCrypt.checkpw(myPassword, myUser.getPassword())) {
            model.addAttribute("passwordError", "La contraseña es incorrecta");
            model.addAttribute("myEmail", myEmail);
            model.addAttribute("myPassword", myPassword);
            return "home.jsp";
        }

        session.setAttribute("currentUser", myUser);
        return "redirect:/programas";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("currentUser");
        return "redirect:/";
    }
}
