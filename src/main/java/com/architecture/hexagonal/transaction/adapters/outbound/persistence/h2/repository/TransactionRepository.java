package com.architecture.hexagonal.transaction.adapters.outbound.persistence.h2.repository;

import com.architecture.hexagonal.transaction.adapters.outbound.persistence.h2.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer> {

}
