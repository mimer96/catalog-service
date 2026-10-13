package com.polarbookshop.catalogservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(BookAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public String manageExistingBook(BookAlreadyExistsException exception){
		return exception.getMessage();
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
    public String manageNotFoundBook(BookNotFoundException exception){
		return exception.getMessage();
	}
}
