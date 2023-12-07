package com.example.demo.service;

import com.example.demo.exceptions.RestaurantException;
import com.example.demo.model.Restaurant;

public interface RestaurantService {
	
	public Restaurant addRestaurant(Restaurant restaurant)throws RestaurantException;
	
	public Restaurant updateRestaurant(Restaurant restaurant)throws RestaurantException;
	
	public Restaurant removeRestaurant(Integer restaurantId)throws RestaurantException;
	
	public Restaurant viewRestaurant(Integer restaurantId)throws RestaurantException;
	
	

}
