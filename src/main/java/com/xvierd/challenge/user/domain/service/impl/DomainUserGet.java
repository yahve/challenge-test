package com.xvierd.challenge.user.domain.service.impl;

import com.xvierd.challenge.user.domain.User;
import com.xvierd.challenge.user.domain.service.DomainUserGetService;
import com.xvierd.challenge.user.infrastructure.repository.mysql.UserRepository;
import java.util.List;
import java.util.Optional;

public class DomainUserGet implements DomainUserGetService {

  private final UserRepository userRepository;

  public DomainUserGet(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<User> findAll() {
    return (List<User>) userRepository.findAll();
  }

  @Override
  public Optional<User> findById(Long id) {
    return userRepository.findById(id);
  }
}
