package com.example.driverlicense.services;

import com.example.driverlicense.models.Person;
import com.example.driverlicense.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends BaseService<Person> {
    @Autowired PersonRepository personRepository;
}
