package com.proyectofinal.credit.repository;

import com.proyectofinal.credit.models.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICreditRepository extends JpaRepository<Credit, Long> {
    public List<Credit> findByCustomerid(String customerid);
    public List<Credit> findByTypecredit(String typecredit);
}
