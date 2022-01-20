package com.cg.car.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.car.dao.TransactionRepository;

import com.cg.car.entity.Transaction;

import com.cg.car.exception.TransactionNotFoundException;
@Service
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	private TransactionRepository transRepo;

	@Override
	public Transaction initiateTransaction(Transaction trx) {
		
		return transRepo.save(trx);
	}

	@Override
	public Transaction getTransactionById(int id) throws TransactionNotFoundException {
		// TODO Auto-generated method stub
Optional<Transaction> existingTransaction = transRepo.findById(id);
		
		Transaction transaction = null;
		if(existingTransaction.isPresent()) {
			transaction=existingTransaction.get();
			
			
		}else {
			throw new TransactionNotFoundException("No such transactin ");
		}
		return transaction;
	}

	@Override
	public List<Transaction> getAllTransaction() {
		// TODO Auto-generated method stub
		return transRepo.findAll();
	}
	

}
