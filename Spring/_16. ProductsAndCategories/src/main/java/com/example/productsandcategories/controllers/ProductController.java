package com.example.productsandcategories.controllers;

import com.example.productsandcategories.models.Category;
import com.example.productsandcategories.models.Product;
import com.example.productsandcategories.services.CategoryService;
import com.example.productsandcategories.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired ProductService productService;
    @Autowired CategoryService categoryService;
    
    @GetMapping("")
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "allProducts.jsp";
    }
    
    @GetMapping("/new")
    public String newProduct(@ModelAttribute("product") Product product) {
        return "newProduct.jsp";
    }
    
    @PostMapping("/new")
    public String createProduct(@Valid @ModelAttribute Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "newProduct.jsp";
        }
        productService.save(product);
        return "redirect:/products";
    }
    
    @GetMapping("/{id}")
    public String showProduct(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        return "showProduct.jsp";
    }
    
    @PutMapping("/{id}/categories")
    public String updateCategories(@PathVariable("id") Long productId, @RequestParam Long categoryId) {
        Product product = productService.findById(productId);
        Category category = categoryService.findById(categoryId);
        Set<Category> categories = product.getCategories();
        
        categories.add(category);
        product.setCategories(categories);
        productService.save(product);
        
        return "redirect:/products/" + productId;
    }
}
