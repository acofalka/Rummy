package model.cards;

import java.util.ArrayList;
import java.util.Random;


public class CardsDeck extends CardsCollection{

	private Random random = new Random();
	
	public CardsDeck(){
		cards = new boolean[54];
		fullDeck();
	}
	
	public void fullDeck(){
		for(int i = 0; i < maxNumberOfCards; i++)
			cards[i] = true;
		numberOfCards = maxNumberOfCards;
	}
	
	public Card takeCard(){
		if (numberOfCards == 0)
			return null;
		int randomCardIndex = random.nextInt(numberOfCards);
		int n = 0;
		for (int i = 0; i < 54; i++){
			if (!(cards[i]))
				continue;
			n++;
			if(n == randomCardIndex){
				Card card = new Card(i);
				cards[i] = false;
				numberOfCards--;
				return card;
			}
		}
		return null;
	}
	
	public ArrayList<Card> dealCards(int n){		// returns n random cards from deck
		if (n > maxNumberOfCards || n < 0)
			throw new IllegalArgumentException();
		if(numberOfCards < n)
			return null;
		ArrayList<Card> cards = new ArrayList<Card>();	
		for (int i = 0; i < n; i++)
			cards.add(this.takeCard());
		return cards;
	}
	
	public void copyCards(CardsCollection collection){
		for(int i = 0; i < 54; i++)
			this.cards[i] = collection.containsCard(i);
		this.numberOfCards = collection.getNumberOfCards();
	}
	
	
}
