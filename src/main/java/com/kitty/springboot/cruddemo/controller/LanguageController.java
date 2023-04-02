package com.kitty.springboot.cruddemo.controller;
import com.kitty.springboot.cruddemo.entity.Language;
import com.kitty.springboot.cruddemo.repository.LanguageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    private
    LanguageRepository languageRepository;

    @Autowired
    public LanguageController(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Language> getLanguageById(@PathVariable Integer id) {
        Optional<Language> language = languageRepository.findById(id);
        return language.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Language> createLanguage(@RequestBody Language language) {
        Language newLanguage = languageRepository.save(language);
        return ResponseEntity.ok(newLanguage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Language> updateLanguage(@PathVariable Integer id, @RequestBody Language language) {
        Optional<Language> existingLanguage = languageRepository.findById(id);
        if (existingLanguage.isPresent()) {
            language.setId(id);
            Language updatedLanguage = languageRepository.save(language);
            return ResponseEntity.ok(updatedLanguage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLanguage(@PathVariable Integer id) {
        Optional<Language> existingLanguage = languageRepository.findById(id);
        if (existingLanguage.isPresent()) {
            languageRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Language>> getAllLanguages() {
        List<Language> languages = languageRepository.findAll();
        return ResponseEntity.ok(languages);
    }
}

