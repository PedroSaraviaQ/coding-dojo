package com.example.counter;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Counter {
    private int getCount(HttpSession session) {
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 0;
            session.setAttribute("count", 0);
        }
        return count;
    }

    @GetMapping("")
    public String index(HttpSession session) {
        int count = getCount(session);
        session.setAttribute("count", count + 1);
        return "home.jsp";
    }

    @GetMapping("/counter")
    public String counter(HttpSession session) {
        getCount(session);
        return "counter.jsp";
    }

    @PostMapping("/reset")
    public String reset(HttpSession session) {
        session.removeAttribute("count");
        return "redirect:/counter";
    }

    @GetMapping("/take2")
    public String takeTwo(HttpSession session) {
        int count = getCount(session);
        session.setAttribute("count", count + 2);
        return "take2.jsp";
    }
}
