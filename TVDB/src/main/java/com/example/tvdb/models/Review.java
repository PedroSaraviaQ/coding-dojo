package com.example.tvdb.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "reviews")
@Getter
@Setter
public class Review extends BaseModel {

    @Range(min = 1, max = 5, message = "El rating debe estar entre 1 y 5")
    private Double rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_id")
    private Program program;
}
