package com.proyectofinal.yanki.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.proyectofinal.yanki.config.CacheConfig;
import com.proyectofinal.yanki.models.Wallet;
import com.proyectofinal.yanki.repository.WalletRepository;

@Service
public class WalletService implements IWalletService {
	@Autowired
	private WalletRepository repository;

	@Override
	public List<Wallet> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Wallet> findByNumdocument(String numdocument) {
		System.out.println("document"+numdocument);
		return repository.findByNumdocument(numdocument);
	}

	@Override
	public Wallet save(Wallet wallet) {
		return repository.save(wallet);
	}

	@Override
	public void delete(Wallet wallet) {
		repository.delete(wallet);
	}

	@Override
	public Optional<Wallet> findById(Long id) {
		return repository.findById(id);
	}

	
	@Override
    @Cacheable(cacheNames = CacheConfig.USER_CACHE, unless = "#result == null")
	public Wallet findWalletById(Long id) {
		System.out.println("id"+id);
		return repository.findById(id).orElse(null);
	}

	@Override
	public Wallet update(Wallet wallet) {
		return repository.save(wallet);
	}
}
