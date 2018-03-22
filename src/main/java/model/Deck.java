package model;

import java.util.Random;

public class Deck {
	private boolean[] deck = new boolean[54]; // true - card with particular deckId is currently in the deck
	private int numberOfCards;
	private Random random = new Random();
	
	public Deck(){
		fullDeck();
	}
	
	public void fullDeck(){
		for(int i = 0; i < 54; i++)
			deck[i] = true;
		numberOfCards = 54;
	}
	
	public boolean isCardInDeck(int deckId){
		return deck[deckId];
	}
	
	public int getNumberOfCards(){
		return numberOfCards;
	}
}
