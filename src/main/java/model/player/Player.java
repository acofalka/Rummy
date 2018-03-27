package model.player;

import java.util.Collections;
import java.util.List;

import model.cards.Card;
import model.cards.Suit;

public class Player {
	protected List<Card> cards;
	
	public Player(List<Card> cards) {
		this.cards = cards;
	}
	
	public void addCard(Card card){
		cards.add(card);
		Collections.sort(cards);
	}
	
	public int numberOfCards(){
		return cards.size();
	}
	
	public boolean doesHaveCardDeckId(int deckId){
		for(Card card : cards){
			if (card.getDeckId() == deckId)
				return true;
		}
		return false;
	}
	
	public boolean doesHaveCardRank(int rank){
		for(Card card : cards){
			if (card.getRank() == rank)
				return true;
		}
		return false;
	}
	
	public boolean doesHaveCardSuit(Suit suit){
		for(Card card : cards){
			if (card.getSuit() == suit)
				return true;
		}
		return false;
	}
	
	public Card getCardByIndex(int index){
		if (index > cards.size() - 1)
			return null;
		Card card = new Card(cards.get(index));
		return card;
	}
	
	public Card playCardIndex(int index){		
		if (index > cards.size() - 1)
			return null;
		Card card = cards.get(index);
		cards.remove(index);
		return card;
	}
	
	public Card playCardDeckId(int deckId){
		int size = cards.size();
		for(int i = 0; i < size; i++){
			Card card = cards.get(i);
			if (card.getDeckId() == deckId){
				cards.remove(i);
				return card;
			}	
		}
		return null;
	}
	
	public int countPoints(){
		int points = 0;
		for (int i = 0; i < numberOfCards(); i++)
			points += cards.get(i).getPoints();
		return points;
	}
	
	public String toString(){
		if (cards.isEmpty())
			return "Brak kart";
		StringBuilder sb = new StringBuilder("");
		int i = 1;
		for(Card card : cards){
			sb.append(i+": "+card.toString());
			sb.append("\n");
			i++;
		}
		return sb.toString();
	}
}
