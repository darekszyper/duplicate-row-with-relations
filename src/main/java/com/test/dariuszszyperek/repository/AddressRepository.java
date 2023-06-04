package com.test.dariuszszyperek.repository;

import com.test.dariuszszyperek.model.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
