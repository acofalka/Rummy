package model.cards;

import java.util.LinkedList;

public class CardsRun extends CardsGroup {
	
	public CardsRun(){
		cards = new LinkedList<Card>();
	}
	
	public Card firstCard(){	// return first card of the run 
		int deckId = 53;
		for (int i = 0; deckId >= 52 && i < getNumberOfCards(); i++)
			deckId = cards.get(i).getDeckId() - i;	// if it's joker, method returns the card that	
		Card first = new Card(deckId);				// joker replaces
		return first;
	}
	
	public Card lastCard(){
		int deckId = 53;
		for (int i = getNumberOfCards() - 1; deckId >= 52 && i >= 0; i--)
			deckId = cards.get(i).getDeckId() + (getNumberOfCards() - i - 1);
		Card last = new Card(deckId);
		return last;
	}

	@Override
	public int getPoints() {
		if (getNumberOfCards() == 0) return 0;
		int points = 0;
		for (int i = 0; i < getNumberOfCards() - 1; i++){
			if(cards.get(i).getSuit().equals(Suit.JOKER)){
				if (cards.get(i + 1).getRank() > 8)
					points += cards.get(i + 1).getPoints();
				else
					points += (cards.get(i + 1).getPoints()) - 1;
			}
			else
				points += cards.get(i).getPoints();
		}
		if(cards.get(getNumberOfCards() - 1).getSuit().equals(Suit.JOKER) && getNumberOfCards() > 1){
			if (cards.get(getNumberOfCards() - 2).getRank() >= 8)
				points += cards.get(getNumberOfCards() - 2).getPoints();
			else
				points += (cards.get(getNumberOfCards() - 2).getPoints()) + 1;
		}
		else if (!(cards.get(getNumberOfCards() - 1).getSuit().equals(Suit.JOKER)))
			points += cards.get(getNumberOfCards() - 1).getPoints();
		return points;
	}

}
