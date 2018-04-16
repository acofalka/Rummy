package model.cards;

import java.util.LinkedList;

import exceptions.IndexOutOfRangeException;
import exceptions.JokerSwapException;

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
	
	public boolean addCard(Card card){
		boolean wasAdded = false;
		if (getNumberOfCards() < 4){
			if (getNumberOfCards() != 0){	// first card cannot be a joker
				if(cards.get(0).getRank() == card.getRank() || card.getSuit().equals(Suit.JOKER)){
					cards.add(card);
					wasAdded = true;
				}
			}
			else if (getNumberOfCards() == 0 && !(card.getSuit().equals(Suit.JOKER))){
				cards.add(card);
				wasAdded = true;
			}
		}
		return wasAdded;
	}
	
	public boolean addCard(int deckId){
		Card card = new Card(deckId);
		boolean wasAdded = false;
		if (getNumberOfCards() < 4){
			if (getNumberOfCards() != 0){	// first card cannot be a joker
				if(cards.get(0).getRank() == card.getRank() || card.getSuit().equals(Suit.JOKER)){
					cards.add(card);
					wasAdded = true;
				}
			}
			else if (getNumberOfCards() == 0 && !(card.getSuit().equals(Suit.JOKER))){
				cards.add(card);
				wasAdded = true;
			}
		}
		return wasAdded;
	}
	
	public Card getCard(int index){
		if (index > getNumberOfCards() || index < 0)
			throw new IndexOutOfRangeException();
		Card card = cards.get(index);
		return card;
	}
	
	public Card removeCard(int index){
		if (index > getNumberOfCards() || index < 0)
			throw new IndexOutOfRangeException();
		Card card = cards.get(index);
		cards.remove(index);
		return card;
	}
	
	public Card takeJoker(Card card) throws JokerSwapException {
		Card joker = null;
		boolean wasAdded = addCard(card);
		if(getNumberOfCards() > 3 && wasAdded){
			for(int i = 0; i < getNumberOfCards(); i++){
				if (cards.get(i).getSuit().equals(Suit.JOKER)){
					joker = cards.get(i);
					cards.remove(i);
					return joker;
				}
			}
			
		}
		cards.remove(card);
		throw new JokerSwapException();		
	}

}
