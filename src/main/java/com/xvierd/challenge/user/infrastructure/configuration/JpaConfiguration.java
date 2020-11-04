package com.xvierd.challenge.user.infrastructure.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.xvierd.challenge.user.infrastructure.repository.mysql")
@EntityScan(basePackages = "com.xvierd.challenge.user.domain")
public class JpaConfiguration {

}
