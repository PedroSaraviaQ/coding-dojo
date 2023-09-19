package com.example.productsandcategories.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "categories")
@Getter @Setter
public class Category extends BaseModel {
    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    private Set<Product> products;
}
