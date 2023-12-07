package com.example.demo.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.CartException;
import com.example.demo.exceptions.ItemException;
import com.example.demo.model.FoodCart;
import com.example.demo.model.Item;
import com.example.demo.repository.FoodCartRepository;
import com.example.demo.repository.ItemRepository;

@Service
public class FoodCartServiceImpl implements FoodCartService{
	
	@Autowired
	FoodCartRepository foodCartRepository;

	@Autowired
	ItemRepository itemRepository;
	
	
	@Override
	public FoodCart saveCart(FoodCart cart) throws CartException {
		Optional<FoodCart> optionalFoodCart = foodCartRepository.findById(cart.getCartId());
		if(optionalFoodCart.isPresent()) {
			throw new CartException("Cart already exists..");
		}else {
			 return foodCartRepository.save(cart);
		}
	}


	@Override
	public FoodCart clearCart(Integer cartId) throws CartException {
		Optional<FoodCart> optionalFoodCart = foodCartRepository.findById(cartId);
		if(optionalFoodCart.isPresent()) {
			FoodCart cart = optionalFoodCart.get();
			foodCartRepository.delete(cart);
			return cart;
		}else {
			throw new CartException("No Cart found with ID: "+cartId);
		}
	}


	@Override
	public FoodCart viewCart(Integer cartId) throws CartException {
		Optional<FoodCart> optionalFoodCart = foodCartRepository.findById(cartId);
		if(optionalFoodCart.isPresent()) {
			FoodCart cart = optionalFoodCart.get();
			return cart;
		}else {
			throw new CartException("No Cart found with ID: "+cartId);
		}
	}


	@Override
	public FoodCart addItem(Integer cartId, Integer itemId) throws CartException, ItemException {
		Optional<FoodCart> optionalFoodCart = foodCartRepository.findById(cartId);
		if(optionalFoodCart.isPresent()) {
			
			Optional<Item> optionalItem = itemRepository.findById(itemId);
			if(optionalItem.isPresent()) {
				
				FoodCart cart = optionalFoodCart.get();
				Item item = optionalItem.get();
				List<Item> list = new ArrayList<>();
				list.addAll(cart.getItemList());
				list.add(item);
				cart.setItemList(list);
				
				return cart;
				
			}else {
				throw new ItemException("No Item found with ID: "+itemId);
			}
			
		}else {
			throw new CartException("No Cart found with ID: "+cartId);
		}
	}




}
