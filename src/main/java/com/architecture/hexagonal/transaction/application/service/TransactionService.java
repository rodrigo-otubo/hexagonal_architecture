package com.architecture.hexagonal.transaction.application.service;

import com.architecture.hexagonal.transaction.adapters.infra.dto.TransactionDTO;
import com.architecture.hexagonal.transaction.application.domain.TransactionDomain;
import com.architecture.hexagonal.transaction.application.exceptions.TransactionInvalidValueException;
import com.architecture.hexagonal.transaction.application.port.inbound.TransactionServicePort;
import com.architecture.hexagonal.transaction.application.port.outbound.TransactionPersistencePort;

public class TransactionService implements TransactionServicePort {

    private final TransactionPersistencePort transactionPersistencePort;

    public TransactionService(TransactionPersistencePort transactionPersistencePort) {
        this.transactionPersistencePort = transactionPersistencePort;
    }

    @Override
    public TransactionDomain save(TransactionDomain transactionDomain) {
        if (transactionDomain.getValue() < 2){
            throw new TransactionInvalidValueException("Teste");
        }
        return transactionPersistencePort.save(transactionDomain);
    }

    @Override
    public TransactionDomain get(Integer id) {
        return transactionPersistencePort.get(id);
    }

    @Override
    public TransactionDomain update(TransactionDTO transactionDTO) {
        return transactionPersistencePort.update(transactionDTO);
    }

    @Override
    public void delete(Integer id) {
        transactionPersistencePort.delete(id);
    }


}
