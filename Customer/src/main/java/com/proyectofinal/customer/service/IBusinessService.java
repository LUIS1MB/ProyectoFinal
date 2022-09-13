package com.proyectofinal.customer.service;

import com.proyectofinal.customer.models.Business;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBusinessService {
	
	public Flux<Business> findAll();
    public Mono<Business> findById(String id);
    public Flux<Business> findByRuc(String ruc);
    public Mono<Business> save(Business business);
    public Mono<Void> delete(Business business);

}
