package com.polarbookshop.catalogservice.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class BookValidationtest {
	
	private static Validator validator;
	
	@BeforeAll
	static void setUp() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
	
	@Test
	void whenAllFieldsCorrectValidationIsValid() {
		
		var book = new Book(
				"1234567890",
				"Title",
				"Authorr",
				9.97
				);
		
		var violations = validator.validate(book);
		
		assertThat(violations).isEmpty();;
	}
	
	@Test
	void whenOneFieldsNotCorrectValidationIsNotValid() {
		
		var book = new Book(
				"1234adas890",
				"Title",
				"Authorr",
				9.97
				);
		
		var violations = validator.validate(book);
		
		assertThat(violations).isNotEmpty();
	}

}
