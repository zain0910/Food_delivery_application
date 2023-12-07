package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.authexceptions.AuthorizationException;
import com.example.demo.authservice.UserSessionService;
import com.example.demo.exceptions.CustomerException;
import com.example.demo.exceptions.OrderException;
import com.example.demo.model.Item;
import com.example.demo.model.OrderDetails;
import com.example.demo.service.OrderDetailsService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/order")
public class OrderDetailsController {
	
	@Autowired
	OrderDetailsService orderDetailsService;
	
	@Autowired
	UserSessionService userSessionService;
	
	
	
	 @PostMapping("/save")
     public ResponseEntity<OrderDetails> saveOrder(@RequestBody OrderDetails order, @RequestParam String key) throws OrderException, AuthorizationException{
     	
     	Integer sessionId = userSessionService.getUserSessionId(key);
     	
     	if(sessionId != null)
     		return new ResponseEntity<OrderDetails>(orderDetailsService.addOrder(order), HttpStatus.CREATED);
     	else
     		throw new OrderException();
     }
	 
	 
	 @PutMapping("/update")
     public ResponseEntity<OrderDetails> updateOrder(@RequestBody OrderDetails order, @RequestParam String key) throws OrderException, AuthorizationException{
         
     	Integer sessionId = userSessionService.getUserSessionId(key);
     	
     	if(sessionId != null)
     		return new ResponseEntity<OrderDetails>(orderDetailsService.updateOrder(order), HttpStatus.ACCEPTED);
     	else
     		throw new OrderException();
     		
     }
	 
	 
	 @DeleteMapping("/remove/{orderId}")
     public ResponseEntity<OrderDetails> deleteOrder(@PathVariable("orderId") Integer orderId , @RequestParam String key) throws OrderException, AuthorizationException{
     	
     	Integer sessionId = userSessionService.getUserSessionId(key);
     	
     	if(sessionId != null) 
     		return new ResponseEntity<OrderDetails>(orderDetailsService.removeOrder(orderId), HttpStatus.ACCEPTED);
     	
     	else
     		throw new OrderException();
     }
	 
	 @GetMapping("/view/{orderId}")
     public ResponseEntity<OrderDetails> viewOrder(@PathVariable("orderId") Integer orderId,@RequestParam String key) throws OrderException, AuthorizationException{
     	
     	Integer sessionId = userSessionService.getUserSessionId(key);
     	
     	if(sessionId != null)
     		return  new ResponseEntity<OrderDetails>(orderDetailsService.viewOrder(orderId),HttpStatus.FOUND);
     	else
     		throw new OrderException();
     }
	 
	 
	 @GetMapping("/viewbycustomer/{customerId}")
     public ResponseEntity<List<Item>> viewAllOrders(@PathVariable("customerId") Integer customerId,@RequestParam String key) throws OrderException, CustomerException, AuthorizationException{
     	
     	Integer sessionId = userSessionService.getUserSessionId(key);
     	
     	if(sessionId != null)
     		return  new ResponseEntity<List<Item>>(orderDetailsService.viewAllOrdersByCustomer(customerId), HttpStatus.FOUND);
     	else
     		throw new OrderException();
     }

}

