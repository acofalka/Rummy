package modelTests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Card;
import model.Deck;

public class DeckTest {

	@Test
	public void deckConstructorTest() {
		Deck deck = new Deck();
		assertEquals(54, deck.getNumberOfCards());
		for(int i = 0; i < 54; i++)
			assertTrue(deck.isCardInDeck(i));
	}
	
	@Test
	public void takeCardFromDeckTest(){
		Deck deck = new Deck();
		Card cardTaken = deck.takeCard();
		boolean cardInDeck = deck.isCardInDeck(cardTaken.getDeckId());
		assertFalse(cardInDeck);
		assertEquals(53, deck.getNumberOfCards());
	}

}
