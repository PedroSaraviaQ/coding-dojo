package com.example.subscriptions.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "subscriptions")
@Getter @Setter
public class Subscription extends BaseModel {
    @NotNull(message = "Price is required")
    private Double price;
    
    private Boolean available;
    
    @OneToMany(mappedBy = "subscription", fetch = FetchType.LAZY)
    private List<Customer> customers;
}
