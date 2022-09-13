package com.proyectofinal.account.models;

import java.util.List;

import lombok.Data;


@Data
public class ResponseProducts{
    private CustomerPersonal customerPersonal;
	private CustomerBusiness customerBusiness;
	private List<Card> cards;
	private List<Credit> credits;
	private List<Account> accounts;
}
