package com.architecture.hexagonal.transaction.adapters.outbound.persistence.h2;

import com.architecture.hexagonal.transaction.adapters.infra.dto.TransactionDTO;
import com.architecture.hexagonal.transaction.adapters.infra.error.exceptions.BadRequestException;
import com.architecture.hexagonal.transaction.adapters.outbound.persistence.h2.entity.TransactionEntity;
import com.architecture.hexagonal.transaction.adapters.outbound.persistence.h2.repository.TransactionRepository;
import com.architecture.hexagonal.transaction.application.domain.TransactionDomain;
import com.architecture.hexagonal.transaction.application.port.outbound.TransactionPersistencePort;
import org.springframework.stereotype.Component;

@Component
public class H2Persistence implements TransactionPersistencePort {

    private final TransactionRepository transactionRepository;

    public H2Persistence(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    @Override
    public TransactionDomain save(TransactionDomain transactionDomain) {
        var transactionSaved = transactionRepository.save(new TransactionEntity(transactionDomain.getValue()));
        return new TransactionDomain(transactionSaved.getId(), transactionSaved.getValue());
    }

    @Override
    public TransactionDomain get(Integer id) {
        var transaction = transactionRepository.findById(id).orElseThrow( () -> new BadRequestException("Transaction not found"));
        return new TransactionDomain(transaction.getId(), transaction.getValue());
    }

    @Override
    public TransactionDomain update(TransactionDTO transactionDTO) {
        var transactionSaved = transactionRepository.save(new TransactionEntity(transactionDTO.getId(), transactionDTO.getValue()));
        return new TransactionDomain(transactionSaved.getId(), transactionSaved.getValue());
    }

    @Override
    public void delete(Integer id) {
        transactionRepository.delete(new TransactionEntity(id));
    }

}
