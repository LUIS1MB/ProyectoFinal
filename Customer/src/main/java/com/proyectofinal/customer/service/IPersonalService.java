package com.proyectofinal.customer.service;

import com.proyectofinal.customer.models.Personal;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonalService {

	public Flux<Personal> findAll();
    public Mono<Personal> findById(String id);
    public Flux<Personal> findByDni(String dni);
    public Mono<Personal> save(Personal customer);
    public Mono<Void> delete(Personal customer);
    
}
