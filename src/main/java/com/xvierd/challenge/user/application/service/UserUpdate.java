package com.xvierd.challenge.user.application.service;

import static java.lang.String.format;

import com.xvierd.challenge.user.application.exception.UserNotFoundException;
import com.xvierd.challenge.user.domain.User;
import com.xvierd.challenge.user.domain.service.DomainUserGetService;
import com.xvierd.challenge.user.domain.service.DomainUserUpdateService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserUpdate {

  private static final Logger log = LoggerFactory.getLogger(UserUpdate.class);

  private final DomainUserUpdateService updateService;

  private final DomainUserGetService userGetService;

  public UserUpdate(
      DomainUserUpdateService updateService,
      DomainUserGetService userGetService) {
    this.updateService = updateService;
    this.userGetService = userGetService;
  }

  public User updateById(Long userId, User userRequest) {
    Optional<User> maybeUser =  userGetService.findById(userId);

    if (maybeUser.isEmpty()) {
      log.info("the user with id [{}] doesn't exist", userId);
      throw new UserNotFoundException(format("The user with Id %s not found.", userId));
    }

    User user = maybeUser.get();

    user.setBirthDate(userRequest.getBirthDate());
    user.setEmail(userRequest.getEmail());
    user.setName(userRequest.getName());
    user.setAddress(userRequest.getAddress());
    return updateService.update(user);
  }

}
