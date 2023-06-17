package com.inventorymanagement.system.service;

import com.inventorymanagement.system.model.Supplier;
import com.inventorymanagement.system.model.Transaction;
import com.inventorymanagement.system.repository.SupplierRepository;
import com.inventorymanagement.system.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    //Retrieve a list of all Transactions
    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    //creating a new Transaction
    public Transaction saveTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }

    //Retrieve a specific transaction by id
    public Optional<Transaction> getTransactionById(Long id){
        return transactionRepository.findById(id);
    }

    //update a specific transaction by id

    public Transaction updateTransaction(Transaction transaction){

        Transaction existingTransaction = transactionRepository.findById(transaction.getTransaction_id()).orElse(null);
        existingTransaction.setTotal_amount(transaction.getTotal_amount());
//        existingTransaction.getTransactionDate(transaction.getTransactionDate());

        return transactionRepository.save(existingTransaction);

    }

    //Delete a specific Supplier by id
    public String deleteById(Long id){
        transactionRepository.deleteById(id);
        return "Transaction deleted by Id"+id;
    }


}
