package edu.sharif.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculatorApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	void testAddition() {
		float augend = 23;
		float addend = 25;
		URI uri = UriComponentsBuilder.fromHttpUrl(testRestTemplate.getRootUri() + "/sum").queryParam("augend", augend).queryParam("addend", addend).build().toUri();
		ResponseEntity<Float> response = testRestTemplate.getRestTemplate().getForEntity(uri, Float.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(augend + addend, response.getBody());
	}

	@Test
	void testDivision() {
		float dividend = 23;
		float divisor = 0;
		URI uri = UriComponentsBuilder.fromHttpUrl(testRestTemplate.getRootUri() + "/div").queryParam("dividend", dividend).queryParam("divisor", divisor).build().toUri();
		ResponseEntity<Float> response = testRestTemplate.getRestTemplate().getForEntity(uri, Float.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

}
