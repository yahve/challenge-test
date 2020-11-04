package com.xvierd.challenge.user.infrastructure.configuration;

import com.xvierd.challenge.ChallengeApplication;
import com.xvierd.challenge.user.domain.service.impl.DomainUserCreate;
import com.xvierd.challenge.user.domain.service.impl.DomainUserDelete;
import com.xvierd.challenge.user.domain.service.impl.DomainUserGet;
import com.xvierd.challenge.user.domain.service.impl.DomainUserUpdate;
import com.xvierd.challenge.user.domain.service.DomainUserCreateService;
import com.xvierd.challenge.user.domain.service.DomainUserDeleteService;
import com.xvierd.challenge.user.domain.service.DomainUserGetService;
import com.xvierd.challenge.user.domain.service.DomainUserUpdateService;
import com.xvierd.challenge.user.infrastructure.repository.mysql.AddressRepository;
import com.xvierd.challenge.user.infrastructure.repository.mysql.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = ChallengeApplication.class)
public class BeanConfiguration {

  @Bean
  DomainUserCreateService userCreateService(final UserRepository userRepository) {
    return new DomainUserCreate(userRepository);
  }

  @Bean
  DomainUserUpdateService userUpdateService(final UserRepository userRepository, AddressRepository addressRepository) {
    return new DomainUserUpdate(userRepository, addressRepository);
  }

  @Bean
  DomainUserGetService userGetService(final UserRepository userRepository) {
    return new DomainUserGet(userRepository);
  }

  @Bean
  DomainUserDeleteService userDeleteService(final UserRepository userRepository) {
    return new DomainUserDelete(userRepository);
  }
}
