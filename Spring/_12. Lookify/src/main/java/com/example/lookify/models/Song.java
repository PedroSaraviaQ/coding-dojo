package com.example.lookify.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "songs")
@Getter
@Setter
public class Song extends BasicModel {
    @Size(min = 5, message = "Title must be at least 5 characters long")
    private String title;

    @Size(min = 5, message = "Artist must be at least 5 characters long")
    private String artist;

    @NotNull(message = "Rating is required")
    @Range(min = 1, max = 10, message = "Rating must be between 1 and 10")
    private Integer rating;
}
