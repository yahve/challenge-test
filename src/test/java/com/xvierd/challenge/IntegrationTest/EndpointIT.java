package com.xvierd.challenge.IntegrationTest;


import com.xvierd.challenge.user.domain.User;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.junit.jupiter.Testcontainers;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = "test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Testcontainers
abstract class EndpointIT {

  @Autowired
  public TestRestTemplate restTemplate;

  @LocalServerPort
  private int port;

  protected String createUrlWith(String endpoint) {
    return "http://localhost:" + port + endpoint;
  }

  protected TestRestTemplate getRestTemplate() {
    return this.restTemplate;
  }

  protected User createUser() {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");

    User user = UserMotherObject.createNewUser(null, "Xavier", "xavier@gmail.com");

    HttpEntity<User> request = new HttpEntity<>(user, headers);


    ResponseEntity<User> response = this.restTemplate.exchange(createUrlWith("/users/createUsers"), HttpMethod.POST, request, User.class);
    return response.getBody();
  }
}
