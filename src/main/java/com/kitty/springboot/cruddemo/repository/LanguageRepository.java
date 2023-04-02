package com.kitty.springboot.cruddemo.repository;

import com.kitty.springboot.cruddemo.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language,Integer>{
}
