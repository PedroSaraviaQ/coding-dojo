package com.example.thecode;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@Controller
public class NinjaGold {

    @GetMapping("/")
    public String index(HttpSession session) {
        if (session.getAttribute("gold") == null) {
            session.setAttribute("gold", 0);
            session.setAttribute("activities", new ArrayList<String>());
        }
        return "home.jsp";
    }

    @PostMapping("/")
    public String findGold(@RequestParam String activity, HttpSession session) {
        int amount = 0;
        Random random = new Random();

        if (activity.equals("farm")) {
            amount = random.nextInt(11) + 10;
        }
        if (activity.equals("cave")) {
            amount = random.nextInt(6) + 5;
        }
        if (activity.equals("house")) {
            amount = random.nextInt(4) + 2;
        }
        if (activity.equals("casino")) {
            amount = random.nextInt(101) - 50;
        }

        int gold = (int) session.getAttribute("gold");
        session.setAttribute("gold", gold + amount);

        ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
        Date date = new Date();
        if (amount >= 0) {
            activities.add("You entered a " + activity + " and earned " + amount + " gold. (" + date + ")");
        } else {

            activities.add("You entered a " + activity + " and lost " + Math.abs(amount) + " gold. Ouch. (" + date + ")");
        }

        //* This line of code is optional because it's an object.
        // session.setAttribute("activities", activities);

        return "redirect:/";
    }

    @PostMapping("/reset")
    public String reset(HttpSession session) {
        session.setAttribute("gold", 0);
        session.setAttribute("activities", new ArrayList<String>());
        return "redirect:/";
    }
}
