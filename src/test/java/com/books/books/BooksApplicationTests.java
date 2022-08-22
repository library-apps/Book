package com.books.books;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import com.books.books.repository.BookRepository;
import com.books.books.model.Book;
import java.util.ArrayList;
import java.util.List;
// import com.ulisesbocchio.jasyptspringboot.configuration.EnableEncryptablePropertiesConfiguration;
// import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
@DataMongoTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
// @Import(EnableEncryptablePropertiesConfiguration.class)
class BooksApplicationTests {
	@Autowired
    BookRepository bookRepository;

	@Before
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
    @Test
    public void shouldFindAll() {
        List<Book> BookListAll = bookRepository.findAll();

        assertThat(BookListAll).isNotEmpty();
        assertThat(BookListAll.size()).isEqualTo(2);

        Page<Book> BookPage = bookRepository.findAll(PageRequest.of(0, 1));

        assertThat(BookPage.getContent()).isNotEmpty();
        assertThat(BookPage.getContent().size()).isEqualTo(1);
    }
	// void contextLoads() {
	// }

}

// package example.api.rest.repositories;

// import example.api.rest.models.Campaign;
// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.test.context.junit4.SpringRunner;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import static org.assertj.core.api.Assertions.assertThat;

// /**
//  * Integration tests to campaigns repository.
//  */
// @RunWith(SpringRunner.class)
// @DataMongoTest
// public class CampaignsRepositoryTest {

//     @Autowired
//     CampaignsRepository campaignsRepository;
    
//     @Before
//     public void setupBeforeEachTest() throws Exception {
//         List<Campaign> campaignList = new ArrayList<>();
//         Campaign campaign1 = new Campaign();
//         campaign1.setId("1");
//         campaign1.setName("test1");
//         campaign1.setDescription("desc1");
//         campaign1.setUrl("http://test1.test1");
//         campaign1.setEmail("test1@test1");
//         campaignList.add(campaign1);

//         Campaign campaign2 = new Campaign();
//         campaign2.setId("2");
//         campaign1.setName("test2");
//         campaign1.setDescription("desc2");
//         campaign1.setUrl("http://test2.test2");
//         campaign1.setEmail("test2@test2");
//         campaignList.add(campaign2);

//         campaignsRepository.saveAll(campaignList);
//     }

//     @Test
//     public void shouldFindAll() {
//         List<Campaign> campaignListAll = campaignsRepository.findAll();

//         assertThat(campaignListAll).isNotEmpty();
//         assertThat(campaignListAll.size()).isEqualTo(2);

//         Page<Campaign> campaignPage = campaignsRepository.findAll(PageRequest.of(0, 1));

//         assertThat(campaignPage.getContent()).isNotEmpty();
//         assertThat(campaignPage.getContent().size()).isEqualTo(1);
//     }

//     @Test
//     public void shouldFindById() {
//         Optional<Campaign> campaign = campaignsRepository.findById("1");

//         assertThat(campaign.isPresent());
//         assertThat(campaign.get().getId()).isEqualTo("1");

//         campaign = campaignsRepository.findById("3");

//         assertThat(!campaign.isPresent());
//     }

//     @Test
//     public void shouldDeleteById() {
//         campaignsRepository.deleteById("2");

//         assertThat(!campaignsRepository.existsById("2"));
//     }

//     
// }