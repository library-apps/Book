package com.books.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import com.books.books.model.Book;
import com.books.books.model.Vendor;
import com.books.books.repository.BookRepository;
import com.books.books.service.BookService;
import com.books.books.repository.VendorRepository;
import com.books.books.service.VendorService;
import java.util.*;

@SpringBootApplication
@EnableAutoConfiguration
public class BooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}
	@Autowired
    BookRepository bookRepository;

	@Autowired
    VendorRepository vendorRepository;
	
	public CommandLineRunner run(BookService bookService){
		return args -> {

			List<Book> bookList = new ArrayList<>();
			Book book1 = new Book();
			book1.setTitle("Keajaiban Toko Kelontong Namiya");
			book1.setAuthor("Keigo H.");
			book1.setSummary("Ketika tiga pemuda berandal bersembunyi di toko kelontong tak berpenghuni setelah melakukan pencurian, sepucuk surat misterius mendadak diselipkan ke dalam toko melalui lubang surat. Surat yang berisi permintaan saran. Sungguh aneh. Namun, surat aneh itu ternyata membawa mereka dalam petualangan melintasi waktu, menggantikan peran kakek pemilik toko kelontong yang menghabiskan tahun-tahun terakhirnya memberikan nasihat tulus kepada orang-orang yang meminta bantuan. Hanya untuk satu malam. Dan saat fajar menjelang, hidup ketiga sahabat itu tidak akan pernah sama lagi...");
			book1.setPages(400);
			book1.setYear(2020);
			book1.setVendor_id("1");
			book1.setImage("https://cdn.gramedia.com/uploads/items/9786020648293_Keajaiban_Toko_Kelontong_Namiya_cov.jpg");
			book1.setIs_deleted(0);
			bookList.add(book1);

			Book book2 = new Book();
			book2.setTitle("Perjuangan");
			book2.setAuthor("Authir");
			book2.setSummary("The quick fox is jumping on the lazy resting dog.");
			book2.setPages(124);
			book2.setYear(1991);
			book2.setVendor_id("1");
			book2.setImage("NULL");
			book2.setIs_deleted(0);
			bookList.add(book2);

			Book book3 = new Book();
			book2.setTitle("Perpustakaan Tengah Malam");
			book2.setAuthor("Matt Haig");
			book2.setSummary("Di antara kehidupan dan kematian terdapat sebuah perpustakaan yang jumlah bukunya tak terhingga. Tiap---tiap buku menyediakan satu kesempatan untuk mencoba kehidupan lain yang bisa dijalani sehingga kau bisa melihat apa yang terjadi kalau kau mengambil keputusan---keputusan berbeda... Akankah kau melakukan apa pun secara berbeda jika kau mendapat kesempatan untuk membatalkan penyesalan--penyesalanmu? Benarkah kehidupan lain akan jauh lebih baik? Nora Seed harus membuat keputusan. Ia dihadapkan pada kemungkinan bisa mengubah hidupnya, memiliki karier yang berbeda, tidak putus dari mantan kekasih, mewujudkan mimpinya sebagai glasiolog. Ia menjelajahi Perpustakaan Tengah Malam untuk memutuskan apa sebenarnya yang menjadikan hidup pantas dijalani. Setelah kehidupan yang diisi berbagai penyesalan dan kegagalan, akankah Nora Seed akhirnya mendapatkan kehidupan yang bisa memberinya kebahagiaan sejati?");
			book2.setPages(368);
			book2.setYear(2021);
			book2.setVendor_id("1");
			book2.setImage("https://cdn.gramedia.com/uploads/items/9786020649320_the_midnight_library_cov.jpg");
			book2.setIs_deleted(0);
			bookList.add(book3);


			Book book4 = new Book();
			book2.setTitle("The Chronicles of Narnia #1: The Magician`s Nephew");
			book2.setAuthor("Authirr");
			book2.setSummary("PETUALANGAN DIMULAI Narnia...tanah tempat para Hewan yang Bisa Bicara tinggal... tempat sang penyihir menunggu... dan dunia yang baru akan terbentuk. Dalam petualangan untuk menyelamatkan seseorang, dua sahabat dipaksa masuk ke dunia lain, tempat seorang penyihir jahat berniat memperbudak mereka. Tetapi, Aslan Sang Singa menyanyikan lagu yang membuat tanah baru tercipta, tanah yang di kemudian hari dikenal sebagai Narnia. Dan di Narnia, segala hal mungkin terjadi...");
			book2.setPages(264);
			book2.setYear(2022);
			book2.setVendor_id("1");
			book2.setImage("https://cdn.gramedia.com/uploads/items/Narnia_1_cov_page-0001.jpg");
			book2.setIs_deleted(0);
			bookList.add(book4);

			Book book5 = new Book();
			book2.setTitle("Man Boy");
			book2.setAuthor("Aliazalea");
			book2.setSummary("Bertahun-tahun Blu naksir berat sama Erik Pentagon. Tapi Erik juga sudah bertahun-tahun naksir cewek lain, cewek yang terlarang buat dia. Semua orang bisa lihat perasaan Blu ke Erik, KECUALI Erik sendiri. Sampai ketika, di satu siang yang gerah, melibatkan kolam renang, air mata, dan seseorang shirtless, dinamika hubungan Erik-Blu berubah drastis! Pelukan yang biasanya mereka lakukan dengan santai, jadi sesuatu yang bikin keduanya panas-dingin. Terutama Erik. Tapi apa keduanya bisa bersama? Erik masih cinta mati sama cinta pertamanya, Blu juga sudah punya pacar (dan pacarnya keren banget). Pertanyaan ini jadi bumerang buat keduanya ketika mereka, di luar kendali, berciuman dengan hot!");
			book2.setPages(0);
			book2.setYear(0);
			book2.setVendor_id("1");
			book2.setImage("https://cdn.gramedia.com/uploads/items/Man_Boy_cov_page-0001.jpg");
			book2.setIs_deleted(0);
			bookList.add(book5);

			Book book6 = new Book();
			book2.setTitle("Perjuaangan");
			book2.setAuthor("Authirr");
			book2.setSummary("The qquick fox is jumping on the lazy resting dog.");
			book2.setPages(124);
			book2.setYear(1991);
			book2.setVendor_id("1");
			book2.setImage("NULL");
			book2.setIs_deleted(0);
			bookList.add(book6);

			bookRepository.saveAll(bookList);
		};
	}

	@Bean
	public CommandLineRunner run (VendorService VendorService){
		return args -> {

			List<Vendor> vendorList = new ArrayList<>();
			Vendor vendor1 = new Vendor();
			vendor1.setVendor_name("Gramedia");
			vendor1.setContact_person("Keigo");
			vendor1.setEmail("keigo@gramedia.com");
			vendor1.setAddress("Jl. Raya ");
			vendor1.setPhone(212121);
			vendor1.setStatus("Active");
			vendor1.setIs_deleted(0);
			vendorList.add(vendor1);

			Vendor vendor2 = new Vendor();
			vendor2.setVendor_name("Penerbit");
			vendor2.setContact_person("Authir");
			vendor2.setEmail("authir@penerbit.com");
			vendor2.setAddress("Jl. Raya");
			vendor2.setPhone(19912121);
			vendor2.setStatus("Not Active");
			vendor2.setIs_deleted(0);
			vendorList.add(vendor2);


			vendorRepository.saveAll(vendorList);
		};
	}

}
