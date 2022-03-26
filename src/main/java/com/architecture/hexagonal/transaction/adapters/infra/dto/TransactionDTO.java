package com.architecture.hexagonal.transaction.adapters.infra.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TransactionDTO {

    private Integer id;
    private Double value;

}
