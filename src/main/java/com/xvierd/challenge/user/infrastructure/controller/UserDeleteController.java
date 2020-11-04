package com.xvierd.challenge.user.infrastructure.controller;

import com.xvierd.challenge.user.application.service.UserDelete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDeleteController {

  private static final Logger log = LoggerFactory.getLogger(UserDeleteController.class);

  private final UserDelete deleteService;

  public UserDeleteController(UserDelete deleteService) {
    this.deleteService = deleteService;
  }

  @Transactional
  @DeleteMapping(
      path = "/deleteUsersById/{userId}",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> deleteById(@PathVariable Long userId) {

    log.info("request delete user id [{}]", userId);

    deleteService.deleteById(userId);

    log.info("user with id [{}] was deleted", userId);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
