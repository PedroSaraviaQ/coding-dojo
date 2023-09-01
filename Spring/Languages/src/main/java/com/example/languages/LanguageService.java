package com.example.languages;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    public Language save(Language language) {
        return languageRepository.save(language);
    }

    public Language findById(Long id) {
        Optional<Language> language = languageRepository.findById(id);
        if (language.isPresent()) {
            return language.get();
        } else {
            return null;
        }
    }

    public void deleteById(Long id) {
        languageRepository.deleteById(id);
    }
}
