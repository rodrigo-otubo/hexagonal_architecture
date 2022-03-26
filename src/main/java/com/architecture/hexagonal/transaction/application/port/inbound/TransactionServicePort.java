package com.architecture.hexagonal.transaction.application.port.inbound;

import com.architecture.hexagonal.transaction.adapters.infra.dto.TransactionDTO;
import com.architecture.hexagonal.transaction.application.domain.TransactionDomain;

public interface TransactionServicePort {

    TransactionDomain save(TransactionDomain transactionDomain);

    TransactionDomain get(Integer id);

    TransactionDomain update(TransactionDTO transactionDTO);

    void delete(Integer id);
}
