package com.books.books;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import com.books.books.repository.BookRepository;
import com.books.books.model.Book;
import java.util.*;

// @SpringBootTest
@DataMongoTest
class BooksApplicationTests {
	@Autowired
    BookRepository bookRepository;

	@Test
    public void setupBeforeEachTest() throws Exception {
        List<Book> bookList = new ArrayList<>();
        Book book1 = new Book();
		book1.setTitle("Perjuangan");
        book1.setAuthor("Authir");
        book1.setSummary("The quick fox is jumping on the lazy resting dog.");
        book1.setPages(123);
        book1.setYear(1991);
        book1.setVendor_id("1");
        book1.setImage("NULL");
        book1.setIs_deleted(0);
		bookList.add(book1);

        Book book2 = new Book();
        book2.setTitle("Perjuaangan");
        book2.setAuthor("Authirr");
        book2.setSummary("The qquick fox is jumping on the lazy resting dog.");
        book2.setPages(124);
        book2.setYear(1991);
        book2.setVendor_id("1");
        book2.setImage("NULL");
        book2.setIs_deleted(0);
		bookList.add(book2);

        bookRepository.saveAll(bookList);
    }
}