package com.kitty.springboot.cruddemo.controller;

import com.kitty.springboot.cruddemo.Pair;
import com.kitty.springboot.cruddemo.entity.*;
import com.kitty.springboot.cruddemo.repository.AddressRepository;
import com.kitty.springboot.cruddemo.repository.BusinessRepository;
import com.kitty.springboot.cruddemo.repository.LocationRepository;
import com.kitty.springboot.cruddemo.repository.ShowRepository;
import org.hibernate.query.ResultListTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    public LocationRepository locationRepository;

    @Autowired
    public AddressRepository addressRepository;

    @Autowired
    public BusinessRepository businessRepository;

    @Autowired
    public ShowRepository showRepository;

    @GetMapping("/locations")
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> result = locationRepository.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/address/{locationId}")
    public List<Integer> getAllAddressesByLocationId(@PathVariable Integer locationId) {
        return addressRepository.findByLocationId(locationId).stream().map(Address::getId).collect(Collectors.toList());
    }

    @GetMapping("/businesses/{addresses}")
    public List<Integer> getAllBusinessesByAddresses(@PathVariable List<Integer> addresses) {
        return businessRepository.findAllByAddressesId(addresses).stream().map(Business::getId).collect(Collectors.toList());

    }
    @GetMapping("/shows/{businesses}")
    public ResultListTransformer getAllShowsByBusinesses(@PathVariable List<Integer> businesses) {
        return showRepository.findAllByBusinessesId(businesses);
    }

}
