package com.example.studentrooster.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "dorms")
@Getter @Setter
public class Dorm extends BaseModel {
    @NotBlank(message = "Name is required")
    private String name;
    
    @OneToMany(mappedBy = "dorm", fetch = FetchType.LAZY)
    private List<Student> students;
}
