package com.example.tvdb.services;

import com.example.tvdb.models.Program;
import com.example.tvdb.models.Review;
import com.example.tvdb.models.User;
import com.example.tvdb.repositories.BaseRepository;
import com.example.tvdb.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Review findByUserAndProgram(User user, Program program) {
        Optional<Review> review = repository.findByUserAndProgram(user, program);
        if (review.isPresent()) {
            return review.get();
        } else {
            return null;
        }
    }
}
