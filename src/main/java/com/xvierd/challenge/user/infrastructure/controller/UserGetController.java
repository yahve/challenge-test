package com.xvierd.challenge.user.infrastructure.controller;

import com.xvierd.challenge.user.application.service.UserRead;
import com.xvierd.challenge.user.domain.User;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional(readOnly = true)
public class UserGetController {

  private static final Logger log = LoggerFactory.getLogger(UserGetController.class);

  private final UserRead userRead;

  public UserGetController(UserRead userRead) {
    this.userRead = userRead;
  }

  @GetMapping(
      path = "/getusers",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<User>> getAll() {

    List<User> users = userRead.getAll();

    log.info("returning [{}] users.", users.size());

    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @GetMapping(
      path = "/getusersById/{userId}",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> getById(@PathVariable Long userId) {

    log.info("request user id [{}]", userId);

    User user = userRead.findById(userId);

    log.info("returning user [{}]", user);

    return new ResponseEntity<>(user, HttpStatus.OK);
  }

}
