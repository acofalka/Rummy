package modelTests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.cards.CardsDeck;
import model.cards.CardsStack;

public class CardsStackTest {

	@Test
	public void stackConstructorTest() {
		CardsStack stack = new CardsStack();
		assertEquals(0, stack.getNumberOfCards());
		for(int i = 0; i < stack.getMaxNumberOfCards(); i++)
			assertFalse(stack.containsCard(i));
	}
	
	@Test
	public void addCardToStackTest(){
		CardsStack stack = new CardsStack();
		stack.addCard(13);
		assertTrue(stack.containsCard(13));
		for(int i = 0; i < stack.getMaxNumberOfCards(); i++)
			if(i != 13)
				assertFalse(stack.containsCard(i));
	}
}
