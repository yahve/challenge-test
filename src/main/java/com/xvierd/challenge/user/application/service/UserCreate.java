package com.xvierd.challenge.user.application.service;

import com.xvierd.challenge.user.domain.User;
import com.xvierd.challenge.user.domain.service.DomainUserCreateService;
import org.springframework.stereotype.Service;

@Service
public class UserCreate {

  private final DomainUserCreateService createService;

  public UserCreate(DomainUserCreateService createService) {
    this.createService = createService;
  }

  public User create(User user) {
    return createService.create(user);
  }
}
