package modelTests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.cards.Card;
import model.cards.CardsDeck;
import model.player.Player;

public class PlayerTest {

	@Test
	public void addCardTest() {
		int numberOfCards = 5;
		CardsDeck deck = new CardsDeck();
		Player player = new Player(deck.dealCards(numberOfCards));
		Card card = deck.takeCard();
		int deckId = card.getDeckId();
		player.addCard(card);
		assertEquals(numberOfCards + 1, player.getNumberOfCards());
		assertTrue(player.doesHaveCardDeckId(deckId));
		for(int i = 0; i < player.getNumberOfCards() - 1; i++)
			assertTrue(player.getCardByIndex(i).compareTo(player.getCardByIndex(i+1)) < 0);
	}

}
