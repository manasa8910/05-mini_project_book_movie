package com.kitty.springboot.cruddemo.repository;

import com.kitty.springboot.cruddemo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

//    @Query("SELECT * FROM Address where Location.id = :location")
//    public List<Address> getAllAddresses(@Param("location") Integer locationId);

    @Query("SELECT a FROM address a where a.location.id = :id")
    List<Address> findByLocationId(@Param("id") int id);
}
