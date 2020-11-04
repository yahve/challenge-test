package com.xvierd.challenge.IntegrationTest;

import com.xvierd.challenge.user.domain.Address;

public class AddressMotherObject {
  static Address createNewAddress(Long id, String zip, String country, String city) {
    Address address = new Address();
    address.setId(id);
    address.setZip(zip);
    address.setStreet("La Pampa");
    address.setCountry(country);
    address.setCity(city);
    return address;
  }
}
