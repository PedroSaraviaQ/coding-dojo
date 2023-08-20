package com.example.tvdb.services;

import com.example.tvdb.models.Review;
import com.example.tvdb.repositories.BaseRepository;
import com.example.tvdb.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService extends BaseService<Review> {
    private final ReviewRepository repository;

    public ReviewService(BaseRepository<Review> repository) {
        super(repository);
        this.repository = (ReviewRepository) repository;
    }

    public List<Review> findAllByProgram_Id(Long id) {
        return repository.findAllByProgram_Id(id);
    }
}
