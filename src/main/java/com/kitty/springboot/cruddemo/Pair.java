package com.kitty.springboot.cruddemo;

import com.kitty.springboot.cruddemo.entity.Business;
import com.kitty.springboot.cruddemo.entity.Movie;

public class Pair{
    private Business business;
    private Movie movie;

    public Pair(Business business, Movie movie) {
        this.business = business;
        this.movie = movie;
    }
}