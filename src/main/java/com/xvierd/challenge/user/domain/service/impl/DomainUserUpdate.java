package com.xvierd.challenge.user.domain.service.impl;

import com.xvierd.challenge.user.domain.Address;
import com.xvierd.challenge.user.domain.User;
import com.xvierd.challenge.user.domain.service.DomainUserUpdateService;
import com.xvierd.challenge.user.infrastructure.repository.mysql.AddressRepository;
import com.xvierd.challenge.user.infrastructure.repository.mysql.UserRepository;
import java.util.Optional;

public class DomainUserUpdate implements DomainUserUpdateService {

  private final UserRepository userRepository;

  private final AddressRepository addressRepository;

  public DomainUserUpdate(UserRepository userRepository,
      AddressRepository addressRepository) {
    this.userRepository = userRepository;
    this.addressRepository = addressRepository;
  }

  @Override
  public User update(User user) {

    if (user.getAddress() == null) {
      user.setAddress(null);
      deleteAddress(user.getId());
    }

    return userRepository.save(user);
  }

  private void deleteAddress(Long userId) {
    Optional<User> maybeUser = userRepository.findById(userId);
    Address address = maybeUser.get().getAddress();
    maybeUser.ifPresent(user -> {
      user.setAddress(null);
      userRepository.save(user);
    });

    if (address != null) {
      maybeUser.ifPresent(user -> addressRepository.delete(user.getAddress()));
    }
  }
}
