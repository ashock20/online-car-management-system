package com.cg.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.cg.car.entity.Transaction;
import com.cg.car.service.TransactionService;

@RestController
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping(value = "/initiatetTransaction")
	public Transaction initiateTransaction(@RequestBody Transaction transaction) {
		return transactionService.initiateTransaction(transaction);
	}
	@GetMapping(value = "/getTransactionById")
	public Transaction getTransactionById(@RequestBody int transactionId) {
		return transactionService.getTransactionById(transactionId);
	}
	@GetMapping(value = "/getAllTransaction")
	public List<Transaction> getAllTransaction() {
		return transactionService.getAllTransaction();
	}

}
