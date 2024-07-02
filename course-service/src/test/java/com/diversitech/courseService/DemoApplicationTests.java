package com.diversitech.courseService;

import com.diversitech.courseService.model.Classes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private RestTemplate externalServiceRestTemplate;

	private MockRestServiceServer mockServer;

	@BeforeEach
	void setUp() {
		mockServer = MockRestServiceServer.createServer(externalServiceRestTemplate);
	}

	@Test
	void contextLoads() {
	}

	@Test
	void testGetClassesByCourseId() {
		int courseId = 1;
		String url = "http://localhost:" + port + "/" + courseId + "/classes";
		System.out.println(url);

		// דימוי התגובה מהסרוויס השני
		mockServer.expect(requestTo("http://classes-service-url/" + courseId))
				.andRespond(withSuccess("[{\"id\":1,\"name\":\"Class 1\"}]", MediaType.APPLICATION_JSON));

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Void> entity = new HttpEntity<>(headers);

		ResponseEntity<List<Classes>> response = restTemplate.exchange(
				url,
				HttpMethod.GET,
				entity,
				new ParameterizedTypeReference<List<Classes>>() {});

		assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().size()).isGreaterThan(0);

		mockServer.verify(); // ווידוא שכל הבקשות נקראו
	}
}
