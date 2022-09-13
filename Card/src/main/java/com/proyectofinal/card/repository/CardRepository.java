package com.proyectofinal.card.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.proyectofinal.card.models.Card;

import reactor.core.publisher.Flux;

public interface CardRepository extends ReactiveMongoRepository<Card,String> {
    Flux<Card> findByNumdocument(String numdocument);
}
