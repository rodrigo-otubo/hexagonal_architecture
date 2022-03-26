package com.architecture.hexagonal.transaction.application.exceptions;

public class TransactionInvalidValueException extends RuntimeException{

    public TransactionInvalidValueException(String message) {
        super(message);
    }

}
