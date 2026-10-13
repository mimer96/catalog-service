package com.polarbookshop.catalogservice.exceptions;

public class BookAlreadyExistsException extends RuntimeException{
	
	public BookAlreadyExistsException(String message) {
		super(message + "è già presente.");
	}

}
