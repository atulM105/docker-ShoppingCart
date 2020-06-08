package com.mindtree.shoppingcart.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.shoppingcart.controller.ShoppingCartController;
import com.mindtree.shoppingcart.exception.ServiceException;

@RestControllerAdvice(assignableTypes = { ShoppingCartController.class })
public class AppExceptionHandler {

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<String> serviceExceptionHandler(ServiceException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	} 
}