package com.proyectofinal.customer.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.proyectofinal.customer.models.Personal;

import reactor.core.publisher.Flux;

public interface PersonalRepository extends ReactiveMongoRepository<Personal,String> {
	
	Flux<Personal> findByDni(String dni);

}
