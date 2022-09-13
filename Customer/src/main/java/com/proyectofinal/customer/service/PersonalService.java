package com.proyectofinal.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinal.customer.models.Personal;
import com.proyectofinal.customer.repository.PersonalRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonalService implements IPersonalService {
	
	@Autowired
	private PersonalRepository repository;

	@Override
	public Flux<Personal> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Mono<Personal> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Flux<Personal> findByDni(String dni) {
		// TODO Auto-generated method stub
		return repository.findByDni(dni);
	}

	@Override
	public Mono<Personal> save(Personal customer) {
		// TODO Auto-generated method stub
		return repository.save(customer);
	}

	@Override
	public Mono<Void> delete(Personal customer) {
		// TODO Auto-generated method stub
		return repository.delete(customer);
	}

}
