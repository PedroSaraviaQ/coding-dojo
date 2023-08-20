package com.example.tvdb.services;

import com.example.tvdb.models.Program;
import com.example.tvdb.repositories.BaseRepository;
import com.example.tvdb.repositories.ProgramRepository;
import org.springframework.stereotype.Service;

@Service
public class ProgramService extends BaseService<Program> {
    private final ProgramRepository repository;

    protected ProgramService(BaseRepository<Program> repository) {
        super(repository);
        this.repository = (ProgramRepository) repository;
    }
}
