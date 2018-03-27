package modelTests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.cards.Card;
import model.cards.Suit;

public class CardTest {

	@Test
	public void cardConstructorTest1() {
		Card card = new Card(14);
		assertEquals(14, card.getDeckId());
		assertEquals(Suit.DIAMOND, card.getSuit());
		assertEquals(1, card.getRank());
	}
	
	@Test
	public void cardConstructorTest2(){
		Card card = new Card(Suit.HEART, 10);
		assertEquals(49, card.getDeckId());
	}
	
	@Test
	public void getPointsTest(){
		Card c1 = new Card(14);
		Card c2 = new Card(52);
		Card c3 = new Card(37);
		Card c4 = new Card(0);
		assertEquals(3, c1.getPoints());
		assertEquals(150, c2.getPoints());
		assertEquals(10, c3.getPoints());
		assertEquals(2, c4.getPoints());
	}

}
