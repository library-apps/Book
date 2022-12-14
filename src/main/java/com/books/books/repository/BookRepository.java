package com.books.books.repository;

// import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.books.books.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer> {

    public Book findByTitle(String bookString);

    // public Book getId(ObjectId id);

    

}
