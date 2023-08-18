package com.example.updateanddelete;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;
    String description;
    String language;
    Integer numberOfPages;

    @Column(updatable = false)
    Date createdAt;
    Date updatedAt;

    protected void onCreate() {
        this.createdAt = new Date();
    }

    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}