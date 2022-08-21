package com.books.books.controller;

import com.books.books.dto.BookDto.*;
import com.books.books.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import lombok.SneakyThrows;
// import io.swagger.annotations.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/book")
// @Api("REST API Documentation for Library Project")
// @ApiResponses(value = { 
//     @ApiResponse(code = 200, message = "Successfully retrieve the data!"),
//     @ApiResponse(code = 201, message = "Successfully create a book!"),
//     @ApiResponse(code = 401, message = "You are not authorized!"),
//     @ApiResponse(code = 403, message = "Forbidden data."),
//     @ApiResponse(code = 404, message = "Data has been deleted or not exist."),
//     @ApiResponse(code = 500, message = "Server Error") 
// })
// @ApiOperation(value = "An API for Books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {
    @Autowired
    private BookService bookService;
    
    @SneakyThrows(Exception.class)
    @GetMapping(value = "/{title}")
    public ResponseEntity<Object> getBook(@PathVariable(value="title") String title){
        log.info("GET http://localhost:8080/api/v1/book/{} is called", title);
		return bookService.getBook(title);
    }

    //POST
    @SneakyThrows(Exception.class)
    @PostMapping(value = "/add")
    public ResponseEntity<Object> createBook(@RequestBody CreateBook dto){
        log.info("POST http://localhost:8080/api/v1/book is called");
        return bookService.createBook(dto);
    }

    //PUT
    @SneakyThrows(Exception.class)
    @PutMapping(value = "/{id_book}")
    public ResponseEntity<Object> updateBook(@RequestBody UpdateBook dto){
        log.info("PUT http://localhost:8080/api/v1/book is called");
        return bookService.updateBook(dto);
    }
    //DELETE
    @SneakyThrows(Exception.class)
    @DeleteMapping(value = "/{id_book}")
    public ResponseEntity<Object> deleteBook(@PathVariable(name = "id") Integer id){
        log.info("DELETE http://localhost:8080/api/v1/book is called");
        return bookService.deleteBook(id);
    }
    //GETALL
    @SneakyThrows(Exception.class)
    @GetMapping(value = "/")
    public ResponseEntity<Object> getBooks(){
        log.info("GET http://localhost:8080/api/v1/book/ is called");
		return bookService.getBooks();
    }
}
