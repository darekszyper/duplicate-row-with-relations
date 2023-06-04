package com.test.dariuszszyperek.repository;

import com.test.dariuszszyperek.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
