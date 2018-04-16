package modelTests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.cards.Card;
import model.cards.CardsRun;

public class CardsRunTest {
	
	@Test
	public void addCardToRunTest(){
		CardsRun run = new CardsRun();
		Card c1 = new Card(4);
		Card c2 = new Card(5);
		Card c3 = new Card(3);
		Card c4 = new Card(10);
		assertTrue(run.addCard(c1));
		assertTrue(run.addCard(c2));
		assertTrue(run.addCard(c3));
		assertFalse(run.addCard(c4));
		assertEquals(3, run.getNumberOfCards());
	}

	@Test
	public void getPointsTest() {
		CardsRun run = new CardsRun();
		// TODO
	}

}
