package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.FoodCart;

@Repository
public interface FoodCartRepository extends JpaRepository<FoodCart, Integer>{

}
