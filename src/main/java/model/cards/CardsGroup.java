package model.cards;

import java.util.List;


public abstract class CardsGroup {
	
	protected List<Card> cards;
	
	public abstract int getPoints();
	
	public int getNumberOfCards(){
		return cards.size();
	}
	
	public Card getCardByIndex(int index){
		if (index >= getNumberOfCards() || index < 0)
			return null;
		Card card = new Card(cards.get(index));
		return card;
	}
	
	public boolean containsJoker(){
		for(int i = 0; i < getNumberOfCards(); i++){
			if(cards.get(i).getSuit().equals(Suit.JOKER))
				return true;
		}
		return false;
	}
}
