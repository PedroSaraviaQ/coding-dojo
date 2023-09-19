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
@RequestMapping("/categories")
public class CategoryController {
    @Autowired CategoryService categoryService;
    @Autowired ProductService productService;
    
    @GetMapping("")
    public String index(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "allCategories.jsp";
    }
    
    @GetMapping("/new")
    public String newCategory(@ModelAttribute("category") Category category) {
        return "newCategory.jsp";
    }
    
    @PostMapping("/new")
    public String createCategory(@Valid @ModelAttribute Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "newCategory.jsp";
        }
        categoryService.save(category);
        return "redirect:/categories";
    }
    
    @GetMapping("/{id}")
    public String showCategory(@PathVariable Long id, Model model) {
        Category category = categoryService.findById(id);
        List<Product> products = productService.findAll();
        model.addAttribute("category", category);
        model.addAttribute("products", products);
        return "showCategory.jsp";
    }
    
    @PutMapping("/{id}/products")
    public String updateProducts(@PathVariable("id") Long categoryId, @RequestParam Long productId) {
        Category category = categoryService.findById(categoryId);
        Product product = productService.findById(productId);
        Set<Category> categories = product.getCategories();
        
        categories.add(category);
        product.setCategories(categories);
        productService.save(product);
        
        return "redirect:/categories/" + categoryId;
    }
}
