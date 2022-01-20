package com.cg.car.service;

import java.util.List;


import com.cg.car.entity.Transaction;
import com.cg.car.exception.TransactionNotFoundException;

public interface TransactionService {
	public Transaction initiateTransaction(Transaction trx);
	public Transaction getTransactionById(int id) throws TransactionNotFoundException;
	public List<Transaction> getAllTransaction(); 
}
