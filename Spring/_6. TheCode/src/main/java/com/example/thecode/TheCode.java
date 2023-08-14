package com.example.thecode;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TheCode {
    @GetMapping("/")
    public String index() {
        return "home.jsp";
    }

    @PostMapping("/")
    public String secret(@RequestParam String code, HttpSession session, RedirectAttributes redirectAttributes) {
        if (code.equals("bushido")) {
            session.setAttribute("access", true);
            return "redirect:/code";
        } else {
            session.removeAttribute("access");
            redirectAttributes.addFlashAttribute("error", "You must train harder!");
            return "redirect:/";
        }
    }

    @GetMapping("/code")
    public String code(HttpSession session) {
        Boolean access = (Boolean) session.getAttribute("access");
        if (access != null && access) {
            return "code.jsp";
        } else {
            return "redirect:/";
        }
    }
}
