package com.example.subscriptions.services;

import com.example.subscriptions.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class BaseService<T> {
    @Autowired private BaseRepository<T> baseRepository;
    
    public List<T> findAll() {
        return baseRepository.findAll();
    }
    
    public T save(T object) {
        return baseRepository.save(object);
    }
    
    public T findById(Long id) {
        return baseRepository.findById(id).orElse(null);
    }
    
    public void deleteById(Long id) {
        baseRepository.deleteById(id);
    }
}
