package model;

public class CardsStack extends CardsCollection {
	
	public CardsStack(){
		cards = new boolean[54];
		emptyDeck();
	}
	
	public void emptyDeck(){
		for(int i = 0; i < maxNumberOfCards; i++)
			cards[i] = false;
		numberOfCards = 0;
	}
	
	public void addCard(int deckNumber){
		cards[deckNumber] = true;
		numberOfCards++;
	}
}
