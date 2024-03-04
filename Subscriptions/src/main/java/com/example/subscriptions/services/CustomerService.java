package com.example.subscriptions.services;

import com.example.subscriptions.models.Customer;
import com.example.subscriptions.models.Subscription;
import com.example.subscriptions.repositories.CustomerRepository;
import com.example.subscriptions.repositories.SubscriptionRepository;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class CustomerService extends BaseService<Customer> {
    @Autowired private CustomerRepository customerRepository;
    @Autowired private SubscriptionRepository subscriptionRepository;
    
    public void register(Customer customer, HttpSession session) {
        String hashedPassword = BCrypt.hashpw(customer.getPassword(), BCrypt.gensalt());
        Subscription subscription = subscriptionRepository.findAll().get(0);
        customer.setPassword(hashedPassword);
        customerRepository.save(customer);
        if (customer.getId() != 1) {
            customer.setSubscription(subscription);
        }
        customerRepository.save(customer);
        session.setAttribute("id", customer.getId());
    }
    
    public boolean login(String email, String password, HttpSession session, RedirectAttributes redirectAttributes) {
        Customer customer = customerRepository.findByEmail(email);
        redirectAttributes.addFlashAttribute("email", email);
        redirectAttributes.addFlashAttribute("password", password);
        if (customer == null) {
            redirectAttributes.addFlashAttribute("emailError", "Email not found");
            return false;
        }
        if (!BCrypt.checkpw(password, customer.getPassword())) {
            redirectAttributes.addFlashAttribute("passwordError", "Incorrect password");
            return false;
        }
        session.setAttribute("id", customer.getId());
        return true;
    }
}
