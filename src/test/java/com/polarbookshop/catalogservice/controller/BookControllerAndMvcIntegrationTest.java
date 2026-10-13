package com.polarbookshop.catalogservice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.polarbookshop.catalogservice.controllers.BookController;
import com.polarbookshop.catalogservice.exceptions.BookNotFoundException;
import com.polarbookshop.catalogservice.services.BookService;

@WebMvcTest(BookController.class)
public class BookControllerAndMvcIntegrationTest {

 @Autowired
 private MockMvc mockMvc;

 @MockitoBean
 private BookService bookService;

 @Test
 void whenBookNotExistingThenShouldReturn404() throws Exception {

     String isbn = "7373737373";

     when(bookService.viewBookDetails(isbn))
             .thenThrow(BookNotFoundException.class);

     mockMvc.perform(get("/books/" + isbn))
             .andExpect(status().isNotFound());

     verify(bookService, times(1)).viewBookDetails(isbn);
 }
}