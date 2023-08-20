package com.example.tvdb.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "programs")
@Getter
@Setter
public class Program extends BaseModel {
    @NotBlank(message = "El título es obligatorio")
    @Column(unique = true)
    private String title;

    @NotBlank(message = "La red es obligatoria")
    private String network;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(min = 10, message = "La descripción debe tener al menos 10 caracteres")
    private String description;

    @OneToMany(mappedBy = "program", fetch = FetchType.LAZY)
    private List<Review> reviews;

    @Transient
    private Double rating;
}
