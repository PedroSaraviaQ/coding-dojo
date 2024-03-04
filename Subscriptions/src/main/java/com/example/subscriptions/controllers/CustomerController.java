package com.example.subscriptions.controllers;

import com.example.subscriptions.models.Customer;
import com.example.subscriptions.models.Subscription;
import com.example.subscriptions.services.CustomerService;
import com.example.subscriptions.services.SubscriptionService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired private CustomerService customerService;
    @Autowired private SubscriptionService subscriptionService;
    
    @GetMapping("/")
    public String index(@ModelAttribute("customer") Customer customer, HttpSession session) {
        Long customerId = (Long) session.getAttribute("id");
        if (customerId == null) {
            return "registration.jsp";
        }
        if (customerId != 1) {
            return "redirect:/users/" + customerId;
        }
        return "redirect:/packages";
    }
    
    @PostMapping("/register")
    public String registerCustomer(@Valid @ModelAttribute Customer customer, BindingResult result, HttpSession session) {
        if (!customer.getPassword().equals(customer.getPasswordConfirmation())) {
            FieldError fieldError = new FieldError("passwordConfirmation", "passwordConfirmation", "Passwords do not match");
            result.addError(fieldError);
        }
        if (result.hasErrors()) {
            return "registration.jsp";
        }
        customerService.register(customer, session);
        return "redirect:/packages";
        
    }
    
    @PostMapping("/login")
    public String loginCustomer(@RequestParam String email, @RequestParam String password, HttpSession session, RedirectAttributes redirectAttributes) {
        if (!customerService.login(email, password, session, redirectAttributes)) {
            return "redirect:/";
        }
        return "redirect:/packages";
    }
    
    @GetMapping("/users/{id}")
    public String showCustomer(@PathVariable Long id, Model model, HttpSession session) {
        Long customerId = (Long) session.getAttribute("id");
        if (customerId == null) {
            return "redirect:/";
        }
        if (customerId == 1 || !customerId.equals(id)) {
            return "redirect:/packages";
        }
        Customer customer = customerService.findById(id);
        List<Subscription> subscriptions = subscriptionService.findAll();
        model.addAttribute("customer", customer);
        model.addAttribute("subscriptions", subscriptions);
        return "user.jsp";
    }
    
    @PutMapping("/users/{id}/package")
    public String updateSubscription(@PathVariable("id") Long customerId, @RequestParam Long subscriptionId, Model model) {
        Customer customer = customerService.findById(customerId);
        Subscription subscription = subscriptionService.findById(subscriptionId);
        customer.setSubscription(subscription);
        customerService.save(customer);
        return "redirect:/users/" + customerId;
    }
    
    @GetMapping("/logout")
    public String logoutCustomer(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
