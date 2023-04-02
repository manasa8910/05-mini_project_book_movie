package com.kitty.springboot.cruddemo.repository;

import com.kitty.springboot.cruddemo.entity.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepository extends JpaRepository<Screen,Integer> {
}
