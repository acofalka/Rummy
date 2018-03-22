package model;

import java.util.Random;

public class Deck {
	private boolean[] deck = new boolean[54]; // true - card with particular deckId is currently in the deck
	private int numberOfCards;
	private Random random = new Random();
	
	public Deck(){
		initDeck();
	}
	
	public void initDeck(){
		for(int i = 0; i < 54; i++)
			deck[i] = true;
		numberOfCards = 54;
	}
}
