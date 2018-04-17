package model.game;

import model.cards.Card;
import model.cards.CardsDeck;
import model.cards.CardsStack;
import model.player.AIPlayer;
import model.player.Player;

public class GamePart {
	private int[] scores;
	private CardsOnTable cardsOnTable;
	private CardsDeck deck;
	private CardsStack stack;
	private Card thrown;
	private Player player;
	private AIPlayer aIPlayer;
	
	public GamePart(){
		scores = new int[2];
		cardsOnTable = new CardsOnTable();
		deck = new CardsDeck();
		stack = new CardsStack();
		thrown = null;
	}
	
	public int getScore(int index){
		if(index != 0 && index != 1)
			throw new IllegalArgumentException();
		return scores[index];
	}
	
	public void start(){
		player = new Player(deck.dealCards(13));
		aIPlayer = new AIPlayer(deck.dealCards(12));
	}
}
