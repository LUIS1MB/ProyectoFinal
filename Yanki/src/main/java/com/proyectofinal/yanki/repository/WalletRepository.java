package com.proyectofinal.yanki.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinal.yanki.models.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long>{
	public List<Wallet> findByNumdocument(String numdocument);
}
