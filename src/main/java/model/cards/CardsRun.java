package model.cards;

import java.util.LinkedList;

import exceptions.IndexOutOfRangeException;
import exceptions.JokerSwapException;

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
	
	public Card getCard(int index){
		if (index >= getNumberOfCards() || index < 0)
			throw new IndexOutOfRangeException();
		Card card = cards.get(index);
		return card;
	}
	
	public Card removeCard(int index){
		if (index >= getNumberOfCards() || index < 0)
			throw new IndexOutOfRangeException();
		Card card = cards.get(index);
		cards.remove(index);
		return card;
	}
	
	public boolean addCard(int deckNumber){	
		boolean wasAdded = false;
		Card card = new Card(deckNumber);
		if(getNumberOfCards() !=0){
			Card p = firstCard();
			Card o = lastCard();
			if(card.getSuit().equals(p.getSuit())){
				if ((card.getRank() == p.getRank() - 1) || (card.getSuit().equals(Suit.JOKER) && 
						!(cards.get(0).getSuit().equals(Suit.JOKER)))){
					wasAdded = true;
					cards.add(0, card);
				}
				else if((card.getRank() == o.getRank() + 1) || (card.getSuit().equals(Suit.JOKER) && 
						!(cards.get(getNumberOfCards() - 1).getSuit().equals(Suit.JOKER)))){
					wasAdded = true;
					cards.add(card);
				}
			}
		}
		else{
			cards.add(card);
			wasAdded = true;
		}
		return wasAdded;
	}
	
	public boolean addCard(Card card){	
		boolean wasAdded = false;
		if(getNumberOfCards() !=0){
			Card p = firstCard();
			Card o = lastCard();
			if(card.getSuit().equals(p.getSuit())){
				if ((card.getRank() == p.getRank() - 1) || (card.getSuit().equals(Suit.JOKER) && 
						!(cards.get(0).getSuit().equals(Suit.JOKER)))){
					wasAdded = true;
					cards.add(0, card);
				}
				else if((card.getRank() == o.getRank() + 1) || (card.getSuit().equals(Suit.JOKER) && 
						!(cards.get(getNumberOfCards() - 1).getSuit().equals(Suit.JOKER)))){
					wasAdded = true;
					cards.add(card);
				}
			}
		}
		else{
			cards.add(card);
			wasAdded = true;
		}
		return wasAdded;
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
	
	public Card takeJoker(Card cardToSwap) throws JokerSwapException {
		if (getNumberOfCards() < 3)
			throw new JokerSwapException();
		Card joker = null;
		for(int i = 0; i < cards.size() - 1; i++){
			if(cards.get(i).getSuit().equals(Suit.JOKER) && (cards.get(i + 1).getDeckId() == cardToSwap.getDeckId() + 1)){
				joker = cards.get(i);
				cards.remove(i);
				cards.add(i, cardToSwap);
				return joker;
			}
		}
		if (cards.get(cards.size() - 1).getSuit().equals(Suit.JOKER)&& cards.get(getNumberOfCards() - 2).getDeckId() == cardToSwap.getDeckId() - 1){
			joker = cards.get(getNumberOfCards() - 1);
			cards.remove(getNumberOfCards() - 1);
			cards.add(cardToSwap);
			return joker;
		}
		throw new JokerSwapException();
	}
	
	public boolean addJokerEnd(Card card){
		if (lastCard().getRank() != 12 && 
				!(cards.get(getNumberOfCards() - 1).getSuit().equals(Suit.JOKER))){
			cards.add(card);
			return true;
		}
		else
			return false;
	}
	
	public boolean addJokerStart(Card card){		
		if (firstCard().getRank() != 0 && !(cards.get(0).getSuit().equals(Suit.JOKER))){
			cards.add(0, card);
			return true;
		}
		else
			return false;
	}

}
