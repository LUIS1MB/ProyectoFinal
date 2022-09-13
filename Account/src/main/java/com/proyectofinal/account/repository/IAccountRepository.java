package com.proyectofinal.account.repository;

import com.proyectofinal.account.models.Account;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Long> {
	
	List<Account> findByCustomerId(String customerId);
	Optional<Account> findFirstByNumaccount(String numaccount);
	
}
