package com.polarbookshop.catalogservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.polarbookshop.catalogservice.domain.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
}
