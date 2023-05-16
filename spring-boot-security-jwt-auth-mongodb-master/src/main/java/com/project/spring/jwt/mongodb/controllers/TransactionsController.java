package com.project.spring.jwt.mongodb.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.spring.jwt.dto.Transactions_list;
import com.project.spring.jwt.mongodb.models.Transactions;
import com.project.spring.jwt.mongodb.payload.response.MessageResponse;
import com.project.spring.jwt.mongodb.repository.TransactionsRepository;

@RequestMapping("/api/transactions")
@RestController

public class TransactionsController {

	@Autowired
    private TransactionsRepository repo;
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('USER')")
    public ResponseEntity<MessageResponse> saveAccountIndex(@Valid @RequestBody Transactions transactionData){
		
		//System.out.println(accountData.getAccount_number());
		
		
        repo.save(transactionData);
        return ResponseEntity.ok(new MessageResponse("Added Successfully"));
		
       
    }

	@PostMapping("/postTransactions/{id}")
	@PreAuthorize("hasRole('USER')")
	public List<Transactions> addTransaction(@PathVariable String id,@RequestBody Transactions_list trns_list){
		List<Transactions>  TransactionsList= null;
		repo.postTransactionById(id,trns_list);
		
		TransactionsList= repo.getTransactionsById(id);
		return TransactionsList;
	}
	
	//update transaction object its in array of object
	@PostMapping("/updatetransaction/{id}/{trnsId}")
	@PreAuthorize("hasRole('USER')")
	public List<Transactions> updateTransaction(@PathVariable String id,@PathVariable String trnsId,@RequestBody Transactions_list trns_list){
		List<Transactions> TransactionList= null;
		
		repo.updateTransactionItemById(id,trnsId,trns_list);
		//System.out.println(gro_item);
		TransactionList = repo.getTransactionsById(id);
		return TransactionList;
	}
	
	//Delete Nested object with in the array of document.
	@PostMapping("/deleteTransactionObject/{id}/{trnsId}")
	@PreAuthorize("hasRole('USER')")
	public List<Transactions> deleteTransactionObject(@PathVariable String id,@PathVariable String trnsId,@RequestBody Transactions_list trns_list) {
				List<Transactions> TransactionsList = null;
				
			    repo.deleteTransactionObjectById(id,trnsId,trns_list);
				//System.out.println(gro_item);
			    TransactionsList = repo.getTransactionsById(id);
				return TransactionsList;
	}
	
	@GetMapping("/getTotalTransactionById/{id}")
	@PreAuthorize("hasRole('USER')")
	public Transactions getTotalTransaction(@PathVariable String id) {
	
		List<Transactions> TransactionsList = null;
		TransactionsList =repo.getTransactionsById(id);
		return TransactionsList.get(0);
		
	}
	
	@GetMapping("/getTransactionFromListById/{id}/{trnsId}")
	@PreAuthorize("hasRole('USER')")
	public List<Transactions> getTransactionFromListById(@PathVariable String id,@PathVariable String trnsId) {
		System.out.println(id);
		System.out.println(trnsId);
		List<Transactions> TransactionsList = null;
		TransactionsList =repo.getTransactionFromListById(id,trnsId);
		return TransactionsList;
		
	}
	
}
