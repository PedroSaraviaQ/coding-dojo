package com.example.driverlicense.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "persons")
@Getter @Setter
public class Person extends BaseModel {
    @NotBlank(message = "First name is required")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Column(name = "last_name")
    private String lastName;

    @OneToOne(mappedBy = "person", fetch = FetchType.LAZY)
    private License license;
}
