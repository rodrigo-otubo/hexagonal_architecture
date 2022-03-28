package com.architecture.hexagonal.transaction.adapters.infra.error;

import com.architecture.hexagonal.transaction.adapters.infra.error.exceptions.BadRequestException;
import com.architecture.hexagonal.transaction.adapters.infra.error.exceptions.BadRequestExceptionDetails;
import com.architecture.hexagonal.transaction.application.exceptions.TransactionInvalidValueException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handleBadRequestException(BadRequestException bre){
        var badRequestExceptionDetails = BadRequestExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Bad Request Exception, check the documentation")
                .details(bre.getMessage())
                .developerMessage(bre.getClass().getName())
                .build();
        return new ResponseEntity<>(badRequestExceptionDetails, HttpStatus.BAD_REQUEST);
    }


    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        var exceptionDetails = ExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .title(ex.getCause().getMessage())
                .details(ex.getMessage())
                .developerMessage(ex.getClass().getName())
                .build();
        return new ResponseEntity(exceptionDetails, headers, status);
    }

    /*
    @ExceptionHandler(TransactionInvalidValueException.class)
    protecte ResponseEntity<Object> transactionInvalidValueException(Exception e){
        var exceptionDetails = ExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value)
                )
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body();
    }
    */

}
