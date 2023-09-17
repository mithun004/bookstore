package com.mkece.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BookStoreSpringbootApplicationTests {

	@Test
	void contextLoads() {
		// Attempt to run the Spring Boot application and capture the context
		ConfigurableApplicationContext context = SpringApplication.run(BookStoreSpringbootApplication.class);

		// Check that the context is not null, indicating successful startup
		assertNotNull(context);
	}

}
