package com.xvierd.challenge.user.domain;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.StringJoiner;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  @NotBlank
  private String name;

  @Column(name = "email")
  @Email
  private String email;

  @Column(name = "birth_date", columnDefinition = "TIMESTAMP")
  private LocalDateTime birthDate;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id", referencedColumnName = "id")
  private Address address;

  public User() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDateTime getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDateTime birthDate) {
    this.birthDate = birthDate;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("name='" + name + "'")
        .add("email='" + email + "'")
        .add("birthDate='" + birthDate + "'")
        .add("address=" + address)
        .toString();
  }
}
