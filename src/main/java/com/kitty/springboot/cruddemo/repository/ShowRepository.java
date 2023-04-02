package com.kitty.springboot.cruddemo.repository;

import com.kitty.springboot.cruddemo.Pair;
import com.kitty.springboot.cruddemo.entity.Business;
import com.kitty.springboot.cruddemo.entity.Movie;
import com.kitty.springboot.cruddemo.entity.Show;
import org.hibernate.query.ResultListTransformer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;



@Repository
public interface ShowRepository extends JpaRepository<Show,Integer> {

    @Query("SELECT  a.startTime, a.business, a.movie FROM movie_show a where a.business.id IN :ids")
    ResultListTransformer findAllByBusinessesId(@Param("ids") List<Integer> ids);
}
