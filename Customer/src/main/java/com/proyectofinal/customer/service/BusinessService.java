package com.proyectofinal.customer.service;

import org.springframework.stereotype.Service;

import com.proyectofinal.customer.models.Business;
import com.proyectofinal.customer.repository.BusinessRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BusinessService implements IBusinessService {

	BusinessRepository repository;
	
	@Override
	public Flux<Business> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Mono<Business> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Flux<Business> findByRuc(String ruc) {
		// TODO Auto-generated method stub
		return repository.findByRuc(ruc);
	}

	@Override
	public Mono<Business> save(Business business) {
		// TODO Auto-generated method stub
		return repository.save(business);
	}

	@Override
	public Mono<Void> delete(Business business) {
		// TODO Auto-generated method stub
		return repository.delete(business);
	}

}
