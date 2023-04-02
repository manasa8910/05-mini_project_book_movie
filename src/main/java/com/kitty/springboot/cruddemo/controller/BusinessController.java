package com.kitty.springboot.cruddemo.controller;
import com.kitty.springboot.cruddemo.entity.Business;
import com.kitty.springboot.cruddemo.repository.BusinessRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/businesses")
public class BusinessController {
    private BusinessRepository businessRepository;

    @Autowired
    public BusinessController(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Business> getBusinessById(@PathVariable Integer id) {
        Optional<Business> business = businessRepository.findById(id);
        return business.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Business> createBusiness(@RequestBody Business business) {
        Business newBusiness = businessRepository.save(business);
        return ResponseEntity.ok(newBusiness);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Business> updateBusiness(@PathVariable Integer id, @RequestBody Business business) {
        Optional<Business> existingBusiness = businessRepository.findById(id);
        if (existingBusiness.isPresent()) {
            business.setId(id);
            Business updatedBusiness = businessRepository.save(business);
            return ResponseEntity.ok(updatedBusiness);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBusiness(@PathVariable Integer id) {
        Optional<Business> existingBusiness = businessRepository.findById(id);
        if (existingBusiness.isPresent()) {
            businessRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Business>> getAllBusinesses() {
        List<Business> businesses = businessRepository.findAll();
        return ResponseEntity.ok(businesses);
    }
}
