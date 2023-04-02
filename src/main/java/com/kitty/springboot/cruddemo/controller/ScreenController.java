package com.kitty.springboot.cruddemo.controller;

import com.kitty.springboot.cruddemo.entity.Screen;
import com.kitty.springboot.cruddemo.repository.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/screens")
public class ScreenController {

    private ScreenRepository screenRepository;

    @Autowired
    public ScreenController(ScreenRepository screenRepository) {
        this.screenRepository = screenRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Screen> getScreenById(@PathVariable Integer id) {
        Optional<Screen> screen = screenRepository.findById(id);
        return screen.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Screen> createScreen(@RequestBody Screen screen) {
        Screen newScreen = screenRepository.save(screen);
        return ResponseEntity.ok(newScreen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Screen> updateScreen(@PathVariable Integer id, @RequestBody Screen screen) {
        Optional<Screen> existingScreen = screenRepository.findById(id);
        if (existingScreen.isPresent()) {
            screen.setId(id);
            Screen updatedScreen = screenRepository.save(screen);
            return ResponseEntity.ok(updatedScreen);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScreen(@PathVariable Integer id) {
        Optional<Screen> existingScreen = screenRepository.findById(id);
        if (existingScreen.isPresent()) {
            screenRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Screen>> getAllScreens() {
        List<Screen> screens = screenRepository.findAll();
        return ResponseEntity.ok(screens);
    }
}

