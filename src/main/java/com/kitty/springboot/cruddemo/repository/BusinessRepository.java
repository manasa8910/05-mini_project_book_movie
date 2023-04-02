package com.kitty.springboot.cruddemo.repository;

import com.kitty.springboot.cruddemo.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessRepository extends JpaRepository<Business,Integer> {

    @Query("SELECT a FROM business a where a.address.id IN :ids")
    List<Business> findAllByAddressesId(@Param("ids") List<Integer> ids);
}
