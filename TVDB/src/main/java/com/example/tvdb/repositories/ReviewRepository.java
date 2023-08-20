package com.example.tvdb.repositories;

import com.example.tvdb.models.Review;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends BaseRepository<Review> {
    List<Review> findAllByProgram_Id(Long id);
}
