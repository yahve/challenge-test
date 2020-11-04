package com.xvierd.challenge.user.domain.service;

import com.xvierd.challenge.user.domain.User;
import java.util.List;
import java.util.Optional;

public interface DomainUserGetService {

  List<User> findAll();

  Optional<User> findById(Long id);

}
