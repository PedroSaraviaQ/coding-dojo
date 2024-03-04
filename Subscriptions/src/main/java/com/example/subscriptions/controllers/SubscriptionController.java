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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/packages")
public class SubscriptionController {
    @Autowired SubscriptionService subscriptionService;
    @Autowired CustomerService customerService;
    
    @GetMapping("")
    public String dashboard(@ModelAttribute("subscription") Subscription subscription, Model model, HttpSession session) {
        Long id = (Long) session.getAttribute("id");
        if (id == null) {
            return "redirect:/";
        }
        if (id != 1) {
            return "redirect:/users/" + id;
        }
        List<Customer> customers = customerService.findAll();
        List<Subscription> subscriptions = subscriptionService.findAll();
        subscriptions = subscriptions.stream()
            .sorted((s1, s2) -> {
                int size1 = (s1.getCustomers() != null) ? s1.getCustomers().size() : 0;
                int size2 = (s2.getCustomers() != null) ? s2.getCustomers().size() : 0;
                return Integer.compare(size2, size1); // Note the order of size2 and size1 for descending order
            })
            .collect(Collectors.toList());
        model.addAttribute("customers", customers);
        model.addAttribute("subscriptions", subscriptions);
        return "dashboard.jsp";
    }
    
    @PostMapping("")
    public String createSubscription(
        @Valid @ModelAttribute Subscription subscription, BindingResult result,
        Model model, HttpSession session
    ) {
        if (result.hasErrors()) {
            return dashboard(subscription, model, session);
        }
        subscription.setAvailable(true);
        subscriptionService.save(subscription);
        return "redirect:/packages";
    }
    
    @GetMapping("/{id}/available")
    public String updateAvailability(@PathVariable Long id) {
        if (id != 1 && id != 2) {
            Subscription subscription = subscriptionService.findById(id);
            subscription.setAvailable(!subscription.getAvailable());
            subscriptionService.save(subscription);
        }
        return "redirect:/packages";
    }
    
    @GetMapping("/{id}/edit")
    public String editSubscription(@PathVariable("id") Long subscriptionId, Model model, HttpSession session) {
        Long customerId = (Long) session.getAttribute("id");
        if (customerId == null) {
            return "redirect:/";
        }
        if (customerId != 1) {
            return "redirect:/users/" + customerId;
        }
        Subscription subscription = subscriptionService.findById(subscriptionId);
        model.addAttribute("subscription", subscription);
        return "package.jsp";
    }
    
    @PutMapping("/{id}/update")
    public String updateSubscription(@PathVariable Long id, @RequestParam Double price) {
        Subscription subscription = subscriptionService.findById(id);
        subscription.setPrice(price);
        subscriptionService.save(subscription);
        return "redirect:/packages";
    }
    
    @DeleteMapping("/{id}/delete")
    public String deleteSubscription(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Subscription subscription = subscriptionService.findById(id);
        if (subscription.getCustomers() == null) {
            subscriptionService.deleteById(id);
            return "redirect:/packages";
        }
        if (subscription.getCustomers().isEmpty()) {
            subscriptionService.deleteById(id);
            return "redirect:/packages";
        }
        redirectAttributes.addFlashAttribute("error", "Some costumers are still subscribed to this package.");
        return "redirect:/packages/{id}/edit";
    }
}
