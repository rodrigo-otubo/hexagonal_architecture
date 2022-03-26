package com.architecture.hexagonal.transaction.application.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TransactionDomain {

    private Integer id;
    private Double value;

    public TransactionDomain(Double value) {
        this.value = value;
    }

}
