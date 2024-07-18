package com.polarbookshop.catalog_service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.polarbookshop.catalog_service.domain.Book;

@SpringBootTest(
	webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class CatalogServiceApplicationTests {

	@Autowired
	private WebTestClient webTestClient;
	
	@Test
	void whenPOstRequestThenBookCreated() {
		var expectedBook = new Book("1231231231", "Title", "Author", 9.91);
		webTestClient
			.post()
			.uri("/books")
			.bodyValue(expectedBook)
			.exchange()
			.expectStatus().isCreated()
			.expectBody(Book.class).value(actualBook -> {
				assertNotNull(actualBook);
				assertEquals(actualBook.isbn(), expectedBook.isbn());
			});
		
	}

	@Test
	void contextLoads() {
	}

}

