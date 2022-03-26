package com.architecture.hexagonal.transaction.adapters.infra.error;

import com.architecture.hexagonal.transaction.application.exceptions.TransactionInvalidValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(TransactionInvalidValueException.class)
    public ResponseEntity<?> transactionInvalidValueException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("erroMessage", e.getMessage()));
    }

}
