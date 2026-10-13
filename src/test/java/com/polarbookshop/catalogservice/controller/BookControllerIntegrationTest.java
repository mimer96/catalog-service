package com.polarbookshop.catalogservice.controller;

import org.springframework.boot.webtestclient.autoconfigure.AutoConfigureWebTestClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.polarbookshop.catalogservice.domain.Book;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class BookControllerIntegrationTest {
	
	@Autowired
	private WebTestClient webTestClient;
	
	@Test
	void whenPostRequestThenBookCreated() {
		
		var book = new Book(
				"1234567890",
				"Title",
				"Authorr",
				9.97
				);
		
		webTestClient
			.post()
			.uri("/books")
			.bodyValue(book)
			.exchange()
			.expectStatus().isCreated()
			.expectBody(Book.class).isEqualTo(book);		

	}
}