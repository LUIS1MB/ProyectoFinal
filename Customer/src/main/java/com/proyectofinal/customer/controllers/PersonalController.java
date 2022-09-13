package com.proyectofinal.customer.controllers;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.WebExchangeBindException;

import com.proyectofinal.customer.models.Personal;
import com.proyectofinal.customer.service.IPersonalService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/Personal")
public class PersonalController {

	@Autowired
    private IPersonalService service;

    @GetMapping
    public Flux<Personal> listar() {
        return service.findAll();
    }

    @GetMapping("/dni/{dni}")
    public Mono<Personal> findByDni(@PathVariable String dni) {
        return service.findByDni(dni).next();
    }
    
    @GetMapping("/{id}")
    public Mono<ResponseEntity<Personal>> detail(@PathVariable String id) {
        return service.findById(id).map(p -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p))
                .defaultIfEmpty(ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(new Personal()));
    }

    @PostMapping
    public Mono<ResponseEntity<Map<String, Object>>> save(@Valid @RequestBody Mono<Personal> monoCustomer) {
        Map<String, Object> result = new HashMap<String, Object>();
        return monoCustomer.flatMap(customer -> {
            return service.save(customer).map(p -> {
                result.put("Cliente", p);
                result.put("mensaje", "Cliente guardado con éxito");
                return ResponseEntity
                        .created(URI.create("/api/Personal/".concat(customer.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(result);
            });
        }).onErrorResume(err -> {
            return Mono.just(err).cast(WebExchangeBindException.class)
                    .flatMap(e -> Mono.just(e.getFieldErrors()))
                    .flatMapMany(errs -> Flux.fromIterable(errs))
                    .map(fieldError -> "El campo " + fieldError.getField() + " " + fieldError.getDefaultMessage())
                    .collectList()
                    .flatMap(list -> {
                        result.put("Errors", list);
                        result.put("status", HttpStatus.BAD_REQUEST.value());
                        return Mono.just(ResponseEntity.badRequest().body(result));
                    });
        });
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Personal>> edit(@RequestBody Personal customer, @PathVariable String id) {
        return service.findById(id).flatMap(p -> {
                    return service.save(p);
                }).map(p -> ResponseEntity.created(URI.create("/api/Personal".concat(p.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> edit(@PathVariable String id) {
        return service.findById(id).flatMap(p -> {
            return service.delete(p).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
        }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }
	
}
