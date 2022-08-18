package com.books.books.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.books.books.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer> {

    public Book findByBookTitle(String bookString);

}
