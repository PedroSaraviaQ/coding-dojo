package com.example.productsandcategories.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "products")
@Getter @Setter
public class Product extends BaseModel {
    @NotBlank(message = "Description is required")
    private String description;
    
    @NotNull(message = "Price is required")
    private Double price;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "products_categories",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;
}
