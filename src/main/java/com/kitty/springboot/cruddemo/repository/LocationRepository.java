package com.kitty.springboot.cruddemo.repository;

import com.kitty.springboot.cruddemo.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location,Integer> {
}
