package model.cards;

import java.util.LinkedList;

public class CardsSet extends CardsGroup {
	
	public CardsSet(){
		cards = new LinkedList<Card>();
	}
	
	@Override
	public int getPoints() {
		if (getNumberOfCards() == 0) return 0;
		int points = (cards.get(0).getPoints()) * getNumberOfCards();
		return points;
	}

}
