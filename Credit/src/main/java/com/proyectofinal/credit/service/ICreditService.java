package com.proyectofinal.credit.service;

import com.proyectofinal.credit.models.Credit;

import java.util.List;
import java.util.Optional;

public interface ICreditService {
    public List<Credit> findAllBusinesscredit();
    public List<Credit> findAllPersonalcredit();
    public Optional<Credit> findById(Long id);
    public List<Credit> findByCustomerId(String customerId);
    public Credit save(Credit personalCredit);
    public void delete(Credit personalCredit);
}
