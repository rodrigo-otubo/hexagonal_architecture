package com.architecture.hexagonal.transaction.adapters.infra.config;

import com.architecture.hexagonal.transaction.adapters.outbound.persistence.h2.H2Persistence;
import com.architecture.hexagonal.transaction.application.service.TransactionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyInjection {

    @Bean
    public TransactionService transactionService(H2Persistence h2Persistence){
        return new TransactionService(h2Persistence);
    }
}
