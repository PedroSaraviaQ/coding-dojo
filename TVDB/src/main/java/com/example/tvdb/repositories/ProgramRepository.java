package com.example.tvdb.repositories;

import com.example.tvdb.models.Program;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends BaseRepository<Program> {
    Boolean existsByTitle(String title);
}
