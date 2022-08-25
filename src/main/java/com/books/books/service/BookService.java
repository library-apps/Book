package com.books.books.service;

import java.util.*;

// import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.*;
// import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import com.books.books.dto.BookDto.*;
import com.books.books.model.*;
import com.books.books.repository.BookRepository;

import lombok.SneakyThrows;
import lombok.val;


@Slf4j
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
	// createBook
    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> createBook(CreateBook dto){
        HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		Map<String, Object> res = new HashMap<String, Object>();

		Book book = new Book();

		book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setSummary(dto.getSummary());
        book.setPages(dto.getPages());
        book.setYear(dto.getYear());
        book.setVendor_id(dto.getVendorId());
        book.setImage(dto.getImage());
        book.setIs_deleted(dto.getIsDeleted());

		bookRepository.save(book);
		log.info("A book created.");

		res.put("code", HttpStatus.CREATED.value());
		res.put("message", "success");
		res.put("data", book);

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }
	
	// updateBook
    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> updateBook(UpdateBook dto){
        HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		Map<String, Object> res = new HashMap<String, Object>();

		Book book = bookRepository.findByTitle(dto.getTitle());
		if(Optional.ofNullable(book).isPresent()){
			book.setTitle(dto.getTitle());
			book.setAuthor(dto.getAuthor());
			book.setSummary(dto.getSummary());
			book.setPages(dto.getPages());
			book.setYear(dto.getYear());
			book.setVendor_id(dto.getVendorId());
			book.setImage(dto.getImage());
			book.setIs_deleted(dto.getIsDeleted());
	
			bookRepository.save(book);
	
			res.put("message", "success");
			res.put("data", book);
		} else {
			res.put("message", "failed");
			res.put("data", null);
		}
        res.put("code", HttpStatus.OK.value());

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }

	// getBook
    @SneakyThrows(Exception.class)
	public ResponseEntity<Object> getBook(String title) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		Map<String, Object> res = new HashMap<String, Object>();

		val aBook = bookRepository.findByTitle(title);

		if (Optional.ofNullable(aBook).isPresent()) {
			res.put("message", "success");
			res.put("data", aBook);
		} else {
			res.put("message", "failed");
			res.put("data", null);
		}

		res.put("code", HttpStatus.OK.value());

		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
	}

	// getBooks
	@SneakyThrows(Exception.class)
	public ResponseEntity<Object> getBooks() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		Map<String, Object> res = new HashMap<String, Object>();

		val books = bookRepository.findAll();

		res.put("code", HttpStatus.OK.value());
		res.put("message", "success");
		res.put("data", books);

		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
	}

	// deleteBook
    @SneakyThrows(Exception.class)
	public ResponseEntity<Object> deleteBook(Integer id) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		Map<String, Object> res = new HashMap<String, Object>();

		val book = bookRepository.findById(id).orElse(null);

		if (Optional.ofNullable(book).isPresent()) {

			book.setDeleted_at(new Date());
            book.setIs_deleted(1);

            bookRepository.save(book);

			res.put("message", "success");
			res.put("data", book);

		} else {
			res.put("message", "failed");
			res.put("data", null);
		}

		res.put("code", HttpStatus.OK.value());

		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res);
	}

    
}
