package com.xvierd.challenge.user.application.service;

import com.xvierd.challenge.user.application.exception.UserNotFoundException;
import com.xvierd.challenge.user.domain.User;
import com.xvierd.challenge.user.domain.service.DomainUserGetService;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserRead {

  private static final Logger log = LoggerFactory.getLogger(UserRead.class);


  private final DomainUserGetService findService;

  public UserRead(DomainUserGetService findService) {
    this.findService = findService;
  }

  public User findById(Long userId) {
    Optional<User> maybeUser = findService.findById(userId);

    if (maybeUser.isEmpty()) {
      log.error("The user with id [{}] doesn't exits.", userId);
      throw new UserNotFoundException("user not found");
    }

    return maybeUser.get();
  }

  public List<User> getAll() {
    return findService.findAll();
  }
}
