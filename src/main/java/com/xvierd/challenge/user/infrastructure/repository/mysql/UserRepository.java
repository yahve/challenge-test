package com.xvierd.challenge.user.infrastructure.repository.mysql;

import com.xvierd.challenge.user.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
