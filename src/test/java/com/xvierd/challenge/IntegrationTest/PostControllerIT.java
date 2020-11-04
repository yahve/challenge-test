package com.xvierd.challenge.IntegrationTest;

import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.xvierd.challenge.user.domain.User;

import java.util.Objects;


import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class PostControllerIT extends EndpointIT {

  @Test
  public void create_user() {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");

    User user = UserMotherObject.createNewUser(null, "Jhon Doe", "xavier@gmail.com");

    HttpEntity<User> request = new HttpEntity<>(user, headers);


    ResponseEntity<User> response = this.restTemplate.exchange(createUrlWith("/users/createUsers"), HttpMethod.POST, request, User.class);

    assertThat(response.getStatusCode(), equalTo(HttpStatus.CREATED));
    assertThat(Objects.requireNonNull(response.getBody()).getName(), equalTo("Jhon Doe"));
    assertNotNull(response.getBody().getId());
  }
}
