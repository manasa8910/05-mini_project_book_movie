package com.kitty.springboot.cruddemo.controller;

import com.kitty.springboot.cruddemo.entity.Show;
import com.kitty.springboot.cruddemo.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shows")
public class ShowController {

    private ShowRepository showRepository;

    @Autowired
    public ShowController(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable Integer id) {
        Optional<Show> show = showRepository.findById(id);
        return show.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Show> createShow(@RequestBody Show show) {
        Show newShow = showRepository.save(show);
        return ResponseEntity.ok(newShow);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Show> updateShow(@PathVariable Integer id, @RequestBody Show show) {
        Optional<Show> existingShow = showRepository.findById(id);
        if (existingShow.isPresent()) {
            show.setId(id);
            Show updatedShow = showRepository.save(show);
            return ResponseEntity.ok(updatedShow);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShow(@PathVariable Integer id) {
        Optional<Show> existingShow = showRepository.findById(id);
        if (existingShow.isPresent()) {
            showRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Show>> getAllShows() {
        List<Show> shows = showRepository.findAll();
        return ResponseEntity.ok(shows);
    }
}

