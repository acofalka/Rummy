package model;

import java.util.Random;

public class Deck {
	private boolean[] deck = new boolean[54]; // true - card with particular deckId is currently in the deck
	private int numberOfCards;
	private Random random = new Random();
	
	private static final int maxCardsInDeck = 54;
	
	public Deck(){
		fullDeck();
	}
	
	public void fullDeck(){
		for(int i = 0; i < maxCardsInDeck; i++)
			deck[i] = true;
		numberOfCards = maxCardsInDeck;
	}
	
	public void emptyDeck(){
		for(int i = 0; i < maxCardsInDeck; i++)
			deck[i] = false;
		numberOfCards = 0;
	}
	
	public Card takeCard(){
		if (numberOfCards == 0)
			return null;
		int randomCardIndex = random.nextInt(numberOfCards);
		int n = 0;
		for (int i = 0; i < 54; i++){
			if (!(deck[i]))
				continue;
			n++;
			if(n == randomCardIndex){
				Card card = new Card(i);
				deck[i] = false;
				numberOfCards--;
				return card;
			}
		}
		return null;
	}
	
	public boolean isCardInDeck(int deckId){
		return deck[deckId];
	}
	
	public int getNumberOfCards(){
		return numberOfCards;
	}
}
