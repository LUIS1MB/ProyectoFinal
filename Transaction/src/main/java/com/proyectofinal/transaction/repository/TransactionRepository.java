package com.proyectofinal.transaction.repository;

import com.proyectofinal.transaction.models.Transaction;

import reactor.core.publisher.Flux;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {
	
	Flux<Transaction> findBySourceAccount(String sourceAccount);
	Flux<Transaction> findTop10BySourceAccountOrderByDateDesc(String sourceAccount);
	
}
