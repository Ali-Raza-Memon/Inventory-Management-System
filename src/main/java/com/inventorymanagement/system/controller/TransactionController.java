package com.inventorymanagement.system.controller;

import com.inventorymanagement.system.model.Transaction;
import com.inventorymanagement.system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    //Retrieve a list of all Transadtion
    @GetMapping("/allTransactions")
    public List<Transaction> getAllSupplier(){
        return transactionService.getAllTransactions();
    }


    //creating a new transaction
    @PostMapping("/transaction/save")
    public Transaction saveTransaction(@RequestBody Transaction transaction){
        return transactionService.saveTransaction(transaction);
    }

    //Retrieve a specific transaction by id
    @GetMapping("/transaction/{id}")
    public Optional<Transaction> getById(@PathVariable Long id){
        return transactionService.getTransactionById(id);
    }

    //update a specific transaction by id
    @PutMapping("/transaction/update")
    public Transaction updateTransaction(@RequestBody Transaction transaction){
        return transactionService.updateTransaction(transaction);
    }

}
