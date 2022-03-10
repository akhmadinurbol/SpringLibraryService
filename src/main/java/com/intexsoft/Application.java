package com.intexsoft;

import com.intexsoft.model.Book;
import com.intexsoft.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(BookRepository bookRepository) {
//		return args -> {
//			String dateString = "10-03-2022";
//			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//			Date date = formatter.parse(dateString);
//			Book book  = new Book("Asimov", "Foundation", date, "Nurbol");
//			bookRepository.save(book);
//		};
//	}

}
