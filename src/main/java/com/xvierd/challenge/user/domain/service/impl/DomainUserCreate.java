package com.xvierd.challenge.user.domain.service.impl;

import com.xvierd.challenge.user.domain.User;
import com.xvierd.challenge.user.domain.service.DomainUserCreateService;
import com.xvierd.challenge.user.infrastructure.repository.mysql.UserRepository;

public class DomainUserCreate implements DomainUserCreateService {

  private final UserRepository userRepository;

  public DomainUserCreate(UserRepository userRepository) {
    this.userRepository = userRepository;
  }


  @Override
  public User create(User user) {
    return userRepository.save(user);
  }
}
