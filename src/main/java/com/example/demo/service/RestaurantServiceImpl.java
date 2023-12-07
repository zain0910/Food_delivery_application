package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.RestaurantException;
import com.example.demo.model.Restaurant;
import com.example.demo.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService{
	
	@Autowired
	RestaurantRepository restaurantRepository;

	
	
	
	@Override
	public Restaurant addRestaurant(Restaurant restaurant) throws RestaurantException {
		Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(restaurant.getRestaurantId());
		if(optionalRestaurant.isPresent()) {
			throw new RestaurantException("Restaurant already exists..");
		}else {
			return restaurantRepository.save(restaurant);
		}
	}




	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantException {
		Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(restaurant.getRestaurantId());
		if(optionalRestaurant.isPresent()) {
			return restaurantRepository.save(restaurant);
		}else {
			throw new RestaurantException("No such Restaurant exists..");
		}
	}




	@Override
	public Restaurant removeRestaurant(Integer restaurantId) throws RestaurantException {
		Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(restaurantId);
		if(optionalRestaurant.isPresent()) {
			Restaurant restaurant = optionalRestaurant.get();
			restaurantRepository.delete(restaurant);
			return restaurant;
		}else {
			throw new RestaurantException("No Restaurant found with ID: "+restaurantId);
		}
	}




	@Override
	public Restaurant viewRestaurant(Integer restaurantId) throws RestaurantException {
		Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(restaurantId);
		if(optionalRestaurant.isPresent()) {
			Restaurant restaurant = optionalRestaurant.get();
			return restaurant;
		}else {
			throw new RestaurantException("No Restaurant found with ID: "+restaurantId);
		}
	}

}
