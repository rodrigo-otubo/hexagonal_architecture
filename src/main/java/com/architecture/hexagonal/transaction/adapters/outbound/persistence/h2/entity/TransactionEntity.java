package com.architecture.hexagonal.transaction.adapters.outbound.persistence.h2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double value;

    public TransactionEntity(Double value){
        this.value = value;
    }

    public TransactionEntity(Integer id){
        this.id = id;
    }

}
