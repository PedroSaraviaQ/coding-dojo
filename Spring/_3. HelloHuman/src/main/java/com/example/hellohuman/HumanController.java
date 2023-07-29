package com.example.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

@RestController
public class HumanController {
    @RequestMapping("/")
    public String greetHuman(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName
    ) {
        //* The "\n" thing is not working
        if (firstName != null && lastName != null) {
            return "Hello " + firstName + " " + lastName + "\nWelcome to Spring Boot";
        }
        return "Hello Human\nWelcome to Spring Boot";
    }
}
