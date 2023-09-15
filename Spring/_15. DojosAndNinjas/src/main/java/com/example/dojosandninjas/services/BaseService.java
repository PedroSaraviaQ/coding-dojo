package com.example.dojosandninjas.services;

import com.example.dojosandninjas.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class BaseService<T> {
    @Autowired BaseRepository<T> baseRepository;

    public List<T> findAll() {
        return baseRepository.findAll();
    }

    public T save(T object) {
        return baseRepository.save(object);
    }

    public T findById(Long id) {
        Optional<T> T = baseRepository.findById(id);
        if (T.isPresent()) {
            return T.get();
        }
        return null;
    }

    public void deleteById(Long id) {
        baseRepository.deleteById(id);
    }
}
