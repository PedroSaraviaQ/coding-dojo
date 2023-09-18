package com.example.studentrooster.services;

import com.example.studentrooster.models.Student;
import com.example.studentrooster.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends BaseService<Student> {
    @Autowired StudentRepository studentRepository;
}
