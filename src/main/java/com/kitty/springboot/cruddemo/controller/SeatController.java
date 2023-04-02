package com.kitty.springboot.cruddemo.controller;

import com.kitty.springboot.cruddemo.entity.Seat;
import com.kitty.springboot.cruddemo.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seats")
public class SeatController {

    private SeatRepository seatRepository;

    @Autowired
    public SeatController(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable Integer id) {
        Optional<Seat> seat = seatRepository.findById(id);
        return seat.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Seat> createSeat(@RequestBody Seat seat) {
        Seat newSeat = seatRepository.save(seat);
        return ResponseEntity.ok(newSeat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seat> updateSeat(@PathVariable Integer id, @RequestBody Seat seat) {
        Optional<Seat> existingSeat = seatRepository.findById(id);
        if (existingSeat.isPresent()) {
            seat.setId(id);
            Seat updatedSeat = seatRepository.save(seat);
            return ResponseEntity.ok(updatedSeat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeat(@PathVariable Integer id) {
        Optional<Seat> existingSeat = seatRepository.findById(id);
        if (existingSeat.isPresent()) {
            seatRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Seat>> getAllSeats() {
        List<Seat> seats = seatRepository.findAll();
        return ResponseEntity.ok(seats);
    }
}

