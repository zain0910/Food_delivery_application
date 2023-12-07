package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant , Integer>{

}
