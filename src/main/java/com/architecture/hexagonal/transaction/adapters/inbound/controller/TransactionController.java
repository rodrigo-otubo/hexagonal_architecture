package com.architecture.hexagonal.transaction.adapters.inbound.controller;

import com.architecture.hexagonal.transaction.adapters.infra.dto.TransactionDTO;
import com.architecture.hexagonal.transaction.application.domain.TransactionDomain;
import com.architecture.hexagonal.transaction.application.port.inbound.TransactionServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/transaction")
public class TransactionController {

    private final TransactionServicePort transactionServicePort;

    public TransactionController(TransactionServicePort transactionServicePort) {
        this.transactionServicePort = transactionServicePort;
    }

    @PostMapping
    public ResponseEntity<TransactionDTO> save(@RequestBody TransactionDTO transactionDTO){
        var transactionSaved = transactionServicePort.save(new TransactionDomain( transactionDTO.getValue()));
        return ResponseEntity.status(HttpStatus.CREATED).body(new TransactionDTO(transactionSaved.getId(), transactionSaved.getValue()));
    }

    @GetMapping("{id}")
    public ResponseEntity<TransactionDTO> get(@PathVariable Integer id){
        var transactionFound = transactionServicePort.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(new TransactionDTO(transactionFound.getId(), transactionFound.getValue()));
    }

    @PutMapping()
    public ResponseEntity<TransactionDTO> update(@RequestBody TransactionDTO transactionDTO){
        var transactionUpdated = transactionServicePort.update(transactionDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new TransactionDTO(transactionUpdated.getId(), transactionUpdated.getValue()));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        transactionServicePort.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted with successfully");
    }

}
