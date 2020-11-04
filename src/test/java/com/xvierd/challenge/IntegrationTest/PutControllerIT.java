package com.xvierd.challenge.IntegrationTest;

import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.xvierd.challenge.user.domain.User;
import java.util.Objects;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PutControllerIT extends EndpointIT {


  @Test
  public void update_user() {
    User user = createUser();

    assertThat(user.getName(), equalTo("Xavier"));
    assertThat(user.getEmail(), equalTo("xavier@gmail.com"));

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");

    User userRequest = UserMotherObject.createNewUser(null, "XavierDavid", "xavierdavid@gmail.com");

    HttpEntity<User> request = new HttpEntity<>(userRequest, headers);


    ResponseEntity<User> response = this.restTemplate.exchange(createUrlWith(format("/users/updateUsersById/%s", user.getId())), HttpMethod.PUT, request, User.class);

    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    assertThat(Objects.requireNonNull(response.getBody()).getName(), equalTo("XavierDavid"));
    assertThat(Objects.requireNonNull(response.getBody()).getEmail(), equalTo("xavierdavid@gmail.com"));
    assertThat(Objects.requireNonNull(response.getBody()).getId(), equalTo(user.getId()));
  }

  @Test
  public void update_user_null_address() {
    User user = createUser();

    assertThat(user.getName(), equalTo("Xavier"));
    assertThat(user.getEmail(), equalTo("xavier@gmail.com"));

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");

    User userRequest = UserMotherObject.createNewUser(null, "XavierDavid", "xavierdavid@gmail.com");
    userRequest.setAddress(null);

    HttpEntity<User> request = new HttpEntity<>(userRequest, headers);


    ResponseEntity<User> response = this.restTemplate.exchange(createUrlWith(format("/users/updateUsersById/%s", user.getId())), HttpMethod.PUT, request, User.class);

    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    assertThat(Objects.requireNonNull(response.getBody()).getName(), equalTo("XavierDavid"));
    assertThat(Objects.requireNonNull(response.getBody()).getEmail(), equalTo("xavierdavid@gmail.com"));
    assertThat(Objects.requireNonNull(response.getBody()).getId(), equalTo(user.getId()));
    assertNull(response.getBody().getAddress());
  }

  @Test
  public void update_user_404_user_not_found() {

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");

    User userRequest = UserMotherObject.createNewUser(null, "XavierDavid", "xavierdavid@gmail.com");

    HttpEntity<User> request = new HttpEntity<>(userRequest, headers);


    ResponseEntity<User> response = this.restTemplate.exchange(createUrlWith(format("/users/updateUsersById/%s", 99999)), HttpMethod.PUT, request, User.class);

    assertThat(response.getStatusCode(), equalTo(HttpStatus.NOT_FOUND));
  }


}
