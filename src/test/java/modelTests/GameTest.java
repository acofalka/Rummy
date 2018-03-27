package modelTests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.game.Game;

public class GameTest {

	@Test
	public void getGameTest() {
		Game game1 = Game.getGame();
		Game game2 = Game.getGame();
		assertTrue(game1 == game2);
	}
}
