package modelTests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import model.cards.Card;
import model.cards.CardsDeck;
import model.cards.CardsStack;

public class CardsDeckTest {

	@Test
	public void deckConstructorTest() {
		CardsDeck deck = new CardsDeck();
		assertEquals(deck.getMaxNumberOfCards(), deck.getNumberOfCards());
		for(int i = 0; i < deck.getMaxNumberOfCards(); i++)
			assertTrue(deck.containsCard(i));
	}
	
	@Test
	public void takeCardFromDeckTest(){
		CardsDeck deck = new CardsDeck();
		Card cardTaken = deck.takeCard();
		boolean cardInDeck = deck.containsCard(cardTaken.getDeckId());
		assertFalse(cardInDeck);
		assertEquals(53, deck.getNumberOfCards());
	}
	
	@Test
	public void dealCardsTest(){
		CardsDeck deck = new CardsDeck();
		List<Card> cards = deck.dealCards(12);
		assertEquals(12, cards.size());
		for(int i = 0; i < 11; i++)
			assertFalse(cards.get(i).equals(cards.get(i+1)));
		for(int i = 0; i < 12; i++){
			int deckId = cards.get(i).getDeckId();
			assertFalse(deck.containsCard(deckId));
		}
	}
	
	@Test
	public void copyCardsTest(){
		CardsDeck deck = new CardsDeck();
		CardsStack stack = new CardsStack();
		stack.addCard(12);
		stack.addCard(41);
		stack.addCard(36);
		deck.copyCards(stack);
		assertTrue(deck.containsCard(12));
		assertTrue(deck.containsCard(41));
		assertTrue(deck.containsCard(36));
		for(int i = 0; i < deck.getMaxNumberOfCards(); i++)
			if(i != 12 && i != 41 && i != 36)
				assertFalse(deck.containsCard(i));
	}
}
