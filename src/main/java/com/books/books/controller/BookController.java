package com.books.books.controller;

import com.books.books.dto.BookDto.*;
import com.books.books.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import lombok.SneakyThrows;
// import org.springframework.security.access.prepost.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/book")
public class BookController {
    @Autowired
    private BookService bookService;
    
    @SneakyThrows(Exception.class)
    @GetMapping(value = "/{title}")
    public ResponseEntity<Object> getBook(@PathVariable(value="title") String title){
        log.info("GET http://localhost:8098/api/v1/book/{} is called", title);
		return bookService.getBook(title);
    }

    //POST
    @SneakyThrows(Exception.class)
    @PostMapping(value = "/add")
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> createBook(@RequestBody CreateBook dto){
        log.info("POST http://localhost:8098/api/v1/book is called");
        return bookService.createBook(dto);
    }

    //PUT
    @SneakyThrows(Exception.class)
    @PutMapping(value = "/{id_book}")
    public ResponseEntity<Object> updateBook(@RequestBody UpdateBook dto){
        log.info("PUT http://localhost:8098/api/v1/book is called");
        return bookService.updateBook(dto);
    }
    //DELETE
    @SneakyThrows(Exception.class)
    @DeleteMapping(value = "/{id_book}")
    public ResponseEntity<Object> deleteBook(@PathVariable(name = "id") Integer id){
        log.info("DELETE http://localhost:8098/api/v1/book is called");
        return bookService.deleteBook(id);
    }
    //GETALL
    @SneakyThrows(Exception.class)
    @GetMapping(value = "/")
    public ResponseEntity<Object> getBooks(){
        log.info("GET http://localhost:8098/api/v1/book/ is called");
		return bookService.getBooks();
    }
}
