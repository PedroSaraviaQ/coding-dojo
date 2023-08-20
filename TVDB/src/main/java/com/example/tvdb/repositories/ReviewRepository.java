package com.example.tvdb.repositories;

import com.example.tvdb.models.Program;
import com.example.tvdb.models.Review;
import com.example.tvdb.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends BaseRepository<Review> {
    List<Review> findAllByProgram_Id(Long id);

    Optional<Review> findByUserAndProgram(User user, Program program);
}
