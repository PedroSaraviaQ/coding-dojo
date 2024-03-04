package com.example.subscriptions.repositories;

import com.example.subscriptions.models.Customer;

public interface CustomerRepository extends BaseRepository<Customer> {
    Customer findByEmail(String email);
}
