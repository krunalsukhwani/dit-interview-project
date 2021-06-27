package com.example.ditinterviewproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(classes = DitInterviewProjectApplicationTests.class)
class DitInterviewProjectApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	RequestBuilder validateAccessOfUserBasedOnToken()
	{
		return MockMvcRequestBuilders
				.get("/hello")
				.accept(MediaType.APPLICATION_JSON)
				.header(HttpHeaders.AUTHORIZATION,"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2aXNocHRsIiwiZXhwIjoxNjI0ODE0OTE4LCJpYXQiOjE2MjQ3OTY5MTh9.6s1xkNFzQ0xUyhYv0NTmQUg_xQk2B3bhgNZC9ODiamqVQfWm0Zgzjo-jZM7cxPpNfhPtRXqck5ixBjT3iytT-A")
				.contentType(MediaType.APPLICATION_JSON);
	}
}
