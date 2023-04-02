package com.kitty.springboot.cruddemo.repository;

import com.kitty.springboot.cruddemo.entity.Movie;
import com.kitty.springboot.cruddemo.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    @Query("SELECT a FROM movie_show a where a.business.id IN :ids")
    List<Movie> findAllByBusinessesId(@Param("ids") List<Integer> ids);

}
