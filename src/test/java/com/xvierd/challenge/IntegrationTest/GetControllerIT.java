package com.xvierd.challenge.IntegrationTest;

import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import com.xvierd.challenge.user.domain.User;
import java.util.List;
import java.util.Objects;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GetControllerIT extends EndpointIT {

  @Test
  public void get_user() {

    User user = createUser();

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");

    HttpEntity<User> request = new HttpEntity<>(headers);


    ResponseEntity<User> response = this.restTemplate.exchange(createUrlWith(format("/users/getusersById/%s", user.getId())), HttpMethod.GET, request, User.class);

    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    assertThat(Objects.requireNonNull(response.getBody()).getName(), equalTo("Xavier"));
    assertThat(Objects.requireNonNull(response.getBody()).getId(), equalTo(user.getId()));
  }

  @Test
  public void get_user_then_404_userNotFound() {

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");

    HttpEntity<User> request = new HttpEntity<>(headers);

    ResponseEntity<User> response = this.restTemplate.exchange(createUrlWith("/users/getusersById/10000"), HttpMethod.GET, request, User.class);

    assertThat(response.getStatusCode(), equalTo(HttpStatus.NOT_FOUND));
  }

  @Test
  public void get_all_users() {

    createUser();
    createUser();

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");

    HttpEntity<User> request = new HttpEntity<>(headers);

    ParameterizedTypeReference<List<User>> responseType = new ParameterizedTypeReference<List<User>>() {};

    ResponseEntity<List<User>> response = this.restTemplate.exchange(createUrlWith("/users/getusers"), HttpMethod.GET, request,  responseType);


    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    assertTrue(Objects.requireNonNull(response.getBody()).size() > 1);
  }

}
