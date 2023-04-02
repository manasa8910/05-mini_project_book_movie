package com.kitty.springboot.cruddemo.repository;

import com.kitty.springboot.cruddemo.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Integer> {
}
