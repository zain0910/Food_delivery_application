package com.example.demo.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.authexceptions.AuthorizationException;

//import com.foodapp.authexceptions.AuthorizationException;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(BillException.class)
	public ResponseEntity<ErrorDetails> billExceptionHandler(BillException billException, WebRequest webRequest){
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setLocalDateTime(LocalDateTime.now());
		errorDetails.setMessage(billException.getMessage());
		errorDetails.setDetails(webRequest.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(CartException.class)
	public ResponseEntity<ErrorDetails> cartExceptionHandler(CartException cartException, WebRequest webRequest){
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setLocalDateTime(LocalDateTime.now());
		errorDetails.setMessage(cartException.getMessage());
		errorDetails.setDetails(webRequest.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ErrorDetails> customerExceptionHandler(CustomerException customerException, WebRequest webRequest){
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setLocalDateTime(LocalDateTime.now());
		errorDetails.setMessage(customerException.getMessage());
		errorDetails.setDetails(webRequest.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(ItemException.class)
	public ResponseEntity<ErrorDetails> itemExceptionHandler(ItemException itemException, WebRequest webRequest){
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setLocalDateTime(LocalDateTime.now());
		errorDetails.setMessage(itemException.getMessage());
		errorDetails.setDetails(webRequest.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(OrderException.class)
	public ResponseEntity<ErrorDetails> orderExceptionHandler(OrderException orderException, WebRequest webRequest){
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setLocalDateTime(LocalDateTime.now());
		errorDetails.setMessage(orderException.getMessage());
		errorDetails.setDetails(webRequest.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(RestaurantException.class)
	public ResponseEntity<ErrorDetails> restaurantExceptionHandler(RestaurantException restaurantException, WebRequest webRequest){
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setLocalDateTime(LocalDateTime.now());
		errorDetails.setMessage(restaurantException.getMessage());
		errorDetails.setDetails(webRequest.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<ErrorDetails> authExceptionHandler(AuthorizationException authorizationException , WebRequest webRequest){
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setLocalDateTime(LocalDateTime.now());
		errorDetails.setMessage(authorizationException.getMessage());
		errorDetails.setDetails(webRequest.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> otherExceptionHandler(Exception exception, WebRequest webRequest){
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setLocalDateTime(LocalDateTime.now());
		errorDetails.setMessage(exception.getMessage());
		errorDetails.setDetails(webRequest.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

