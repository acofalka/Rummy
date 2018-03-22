package model_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Card;
import model.Suit;

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

}
