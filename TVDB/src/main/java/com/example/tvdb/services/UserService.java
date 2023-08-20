package com.example.tvdb.services;

import com.example.tvdb.models.User;
import com.example.tvdb.repositories.BaseRepository;
import com.example.tvdb.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User> {
    private final UserRepository repository;

    protected UserService(BaseRepository<User> repository) {
        super(repository);
        this.repository = (UserRepository) repository;
    }
}
