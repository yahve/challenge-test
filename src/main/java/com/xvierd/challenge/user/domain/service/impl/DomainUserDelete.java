package com.xvierd.challenge.user.domain.service.impl;

import com.xvierd.challenge.user.domain.service.DomainUserDeleteService;
import com.xvierd.challenge.user.infrastructure.repository.mysql.UserRepository;

public class DomainUserDelete implements DomainUserDeleteService {

  private final UserRepository userRepository;

  public DomainUserDelete(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void deleteById(Long id) {
    userRepository.deleteById(id);
  }
}
