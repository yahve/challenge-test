package com.xvierd.challenge.IntegrationTest;

import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import com.xvierd.challenge.user.domain.User;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class DeleteControllerIT extends EndpointIT {


  @Test
  public void delete_user() {
    User user = createUser();
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");

    HttpEntity<User> request = new HttpEntity<>(user, headers);


    ResponseEntity<User> response = this.restTemplate.exchange(createUrlWith(format("/users/deleteUsersById/%s", user.getId())), HttpMethod.DELETE, request, User.class);

    assertThat(response.getStatusCode(), equalTo(HttpStatus.NO_CONTENT));
  }

  @Test
  public void delete_user_then_404_userNotFound() {

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");

    HttpEntity<User> request = new HttpEntity<>(headers);

    ResponseEntity<User> response = this.restTemplate.exchange(createUrlWith("/users/deleteUsersById/9999999"), HttpMethod.DELETE, request, User.class);

    assertThat(response.getStatusCode(), equalTo(HttpStatus.NOT_FOUND));
  }

}
