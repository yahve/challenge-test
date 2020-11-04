package com.xvierd.challenge.user.application.service;

import static java.lang.String.format;

import com.xvierd.challenge.user.application.exception.UserNotFoundException;
import com.xvierd.challenge.user.domain.User;
import com.xvierd.challenge.user.domain.service.DomainUserDeleteService;
import com.xvierd.challenge.user.domain.service.DomainUserGetService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserDelete {

  private static final Logger log = LoggerFactory.getLogger(UserDelete.class);

  private final DomainUserDeleteService deleteService;

  private final DomainUserGetService userGetService;

  public UserDelete(DomainUserDeleteService deleteService,
      DomainUserGetService userGetService) {
    this.deleteService = deleteService;
    this.userGetService = userGetService;
  }

  public void deleteById(Long userId) {

    Optional<User> maybeUser = userGetService.findById(userId);

    if (maybeUser.isEmpty()) {
      log.error("the user with id [{}] does not exists, can't be deleted", userId);
      throw new UserNotFoundException(format("User id [%s] not found", userId));
    }

    deleteService.deleteById(userId);
  }

}
