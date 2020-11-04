package com.xvierd.challenge.IntegrationTest;

import com.xvierd.challenge.user.domain.User;
import java.time.LocalDateTime;

public class UserMotherObject {

  static User createNewUser(Long id, String name, String email) {
    User user = new User();
    user.setId(id);
    user.setName(name);
    user.setBirthDate(LocalDateTime.now());
    user.setEmail(email);
    user.setAddress(AddressMotherObject.createNewAddress(id, "1646", "Argentina", "la pampa"));

    return user;
  }

}
