package com.proyectofinal.bootcoin.repository;

import org.springframework.data.repository.CrudRepository;

import com.proyectofinal.bootcoin.models.User;

public interface IUserRepository extends CrudRepository<User, Long>{

}
