package model.game;

import java.util.ArrayList;

import exceptions.JokerSwapException;
import model.cards.Card;
import model.cards.CardsRun;
import model.cards.CardsSet;


public class CardsOnTable {
	private ArrayList<CardsSet> sets;
	private ArrayList<CardsRun> runs;
	
	public CardsOnTable(){
		this.sets = new ArrayList<CardsSet>();
		this.runs = new ArrayList<CardsRun>();
	}
	
	public int getNumberOfSets(){
		return sets.size();
	}
	
	public int getNumberOfRuns(){
		return runs.size();
	}
	
	public void addSet(CardsSet set){
		sets.add(set);
	}
	
	public void addRun(CardsRun run){
		runs.add(run);
	}
	
	public boolean addCardToRun(Card card, int runIndex){
		boolean wasAdded = runs.get(runIndex).addCardsToRunOnTheTable(card);
		return wasAdded;
	}
	
	public boolean addCardToSet(Card card, int index){
		boolean wasAdded = sets.get(index).addCard(card);
		return wasAdded;
	}
	
	public boolean addJokerToRunEnd(int runID, Card card){
		boolean wasAdded = runs.get(runID).addJokerEnd(card);
		return wasAdded;
	}
	
	public boolean addJokerToRunStart(int index, Card card){
		boolean wasAdded = runs.get(index).addJokerStart(card);
		return wasAdded;
	}
	
	
	public Card takeJokerFromRun(Card cardToSwap, int runIndex) throws JokerSwapException {
		Card card = runs.get(runIndex).takeJoker(cardToSwap);
		return card;
	}
	
	public Card takeJokerFromSet(Card cardToSwap, int setIndex) throws JokerSwapException {			// jak wy¿ej, ale z grupy
		Card card = sets.get(setIndex).takeJoker(cardToSwap);
		return card;
	} 
	
	public boolean isJokerInRun(int runIndex){
		return runs.get(runIndex).containsJoker();
	}
	
	public boolean isJokerInSet(int setIndex){
		return sets.get(setIndex).containsJoker();
	}
	
	public Card getCardFromRun(int cardIndex, int runIndex){
		Card card = new Card(runs.get(runIndex).getCard(cardIndex));
		return card;
		
	}
	
	public Card getCardFromSet(int cardIndex, int runIndex){
		Card card = new Card(sets.get(runIndex).getCard(cardIndex));
		return card;
	}
	
	public int numberOfCardsInRun(int runIndex){
		return runs.get(runIndex).getNumberOfCards();
	}
	
	public int numberOfCardsInSet(int setIndex){
		return sets.get(setIndex).getNumberOfCards();
	}
	
	public void clearTable(){			// remove all runs and sets from the table
		runs.clear();
		sets.clear();
	}
}
