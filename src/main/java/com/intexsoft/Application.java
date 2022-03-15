package com.intexsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
//	Insert Into library (library_id, library_name)
//	VALUES
//			(1, 'Lenina'),
//			(2, 'Karbysheva'),
//			(3, 'GRSU')
//
//			   insert into book (id, author, issued_date, issued_to, name, library_id)
//			   VALUES
//			   (1, 'Asimov', 'Foundation', '2006.12.10', 'Ruksha', 1),
//			   (2, 'Bulgakov', 'Margaritha', '', '', 2),
//			   (3, 'Bulgakov', 'SobachjeSerdce', '', '', 3),
//			   (4, 'Oreilly', 'ThinkingInJava', '2006.12.06', 'Maizik', 2),
//			   (5, 'Akhmadi', 'HeadFirstJava', '2022.02.13', 'Olzhas', 3),
//			   (6, 'Yakov', 'Hibernate', '', '', 1)
