package com.xvierd.challenge.user.domain;

import java.util.StringJoiner;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "street")
  private String street;

  @Column(name = "state")
  private String state;

  @Column(name = "city")
  private String city;

  @Column(name = "country")
  private String country;

  @Column(name = "zip")
  private String zip;

  public Address() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Address.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("street='" + street + "'")
        .add("state='" + state + "'")
        .add("city='" + city + "'")
        .add("country='" + country + "'")
        .add("zip='" + zip + "'")
        .toString();
  }
}
