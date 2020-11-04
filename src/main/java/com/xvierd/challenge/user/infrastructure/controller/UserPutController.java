package com.xvierd.challenge.user.infrastructure.controller;

import com.xvierd.challenge.user.application.service.UserUpdate;
import com.xvierd.challenge.user.domain.User;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserPutController {

  private static final Logger log = LoggerFactory.getLogger(UserPutController.class);

  private final UserUpdate userUpdate;

  public UserPutController(UserUpdate userUpdate) {
    this.userUpdate = userUpdate;
  }

  @Transactional
  @PutMapping(
      path = "/updateUsersById/{userId}",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> updateById(
      @PathVariable Long userId,
      @RequestBody @Validated User userRequest) {

    log.info("request update user id [{}] with data [{}].", userId, userRequest);

    User user = userUpdate.updateById(userId, userRequest);

    log.info("the user id [{}] was updated.", userId);

    return new ResponseEntity<>(user, HttpStatus.OK);
  }

}
