package com.proyectofinal.card.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CardList {
	private List<Card> cards;
	public CardList() {
		cards = new ArrayList<>();
	}
}
