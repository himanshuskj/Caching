package com.practise.cache;

import com.practise.cache.domain.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EhApplication {

	public static void main(String[] args) {
		SpringApplication.run(EhApplication.class, args);

//		Book b = new Book();
//		b.setAuthor("Himanshu");
//		b.setCategory("a");
//		b.setEdition("s");
//		b.setName("asd");
//		b.setPublisher("sad");
//

	}

}
