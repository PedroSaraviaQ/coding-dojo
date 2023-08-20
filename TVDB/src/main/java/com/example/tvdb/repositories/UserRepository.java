package com.example.tvdb.repositories;

import com.example.tvdb.models.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {
    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}
