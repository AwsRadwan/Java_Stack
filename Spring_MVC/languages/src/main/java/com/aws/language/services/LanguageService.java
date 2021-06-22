package com.aws.language.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aws.language.models.Language;
import com.aws.language.repositories.LanguageRepository;

@Service
public class LanguageService {
	
private final LanguageRepository languageRepository;
    
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    // returns all the books
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    // creates a book
    public Language createLanguage(Language b) {
        return languageRepository.save(b);
    }
    // retrieves a book
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    public Language updateLanguage(Language b) {
        return languageRepository.save(b);
    }
    public void deleteLanguage(Language b) {
        languageRepository.delete(b);
    }

}
