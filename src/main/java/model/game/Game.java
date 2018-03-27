package model.game;

public class Game {
	
	private static Game game = null;
	
	private GamePart currentGamePart = null;
	private int[] scores;
	
	private Game() {
	    scores = new int[2];
	}
	
	public static Game getGame(){
		if(game == null)
	         game = new Game();
	    return game;
	}
	
	public GamePart getCurrentGamePart(){
		return currentGamePart;
	}
	
	public void startGame(){
		currentGamePart = new GamePart();
	}
	
	public void endGamePart(){
		for(int i = 0; i < 2; i++)
			scores[i] += currentGamePart.getScore(i);
		currentGamePart = null;
	}
}
