package com.xvierd.challenge.user.infrastructure.controller;

import com.xvierd.challenge.user.application.service.UserCreate;
import com.xvierd.challenge.user.domain.User;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserPostController {

  private static final Logger log = LoggerFactory.getLogger(UserPostController.class);

  private final UserCreate userCreate;

  public UserPostController(UserCreate userCreate) {
    this.userCreate = userCreate;
  }

  @Transactional
  @PostMapping(
      path = "/createUsers",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> create(@RequestBody @Validated User userRequest) {

    log.info("Creating new user with data [{}]", userRequest);

    User user = userCreate.create(userRequest);

    log.info("The user [{}] was created", user);
    return new ResponseEntity<>(user, HttpStatus.CREATED);
  }

}
