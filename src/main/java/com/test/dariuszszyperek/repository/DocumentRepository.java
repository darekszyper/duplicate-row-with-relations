package com.test.dariuszszyperek.repository;

import com.test.dariuszszyperek.model.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<DocumentEntity, Long> {
}
