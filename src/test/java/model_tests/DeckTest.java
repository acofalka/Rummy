package model_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Deck;

public class DeckTest {

	@Test
	public void deckConstructorTest() {
		Deck deck = new Deck();
		assertEquals(54, deck.getNumberOfCards());
		for(int i = 0; i < 54; i++)
			assertTrue(deck.isCardInDeck(i));
	}

}
