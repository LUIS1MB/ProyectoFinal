package com.proyectofinal.customer.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.proyectofinal.customer.models.Business;

import reactor.core.publisher.Flux;

public interface BusinessRepository extends ReactiveMongoRepository<Business,String>{
	
	   Flux<Business> findByRuc(String ruc);
	
}
