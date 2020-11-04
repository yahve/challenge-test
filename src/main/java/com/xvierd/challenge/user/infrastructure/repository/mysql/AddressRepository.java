package com.xvierd.challenge.user.infrastructure.repository.mysql;

import com.xvierd.challenge.user.domain.Address;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {

}
