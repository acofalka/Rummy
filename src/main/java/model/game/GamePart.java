package model.game;

public class GamePart {
	private int[] scores;
	
	public GamePart(){
		scores = new int[2];
	}
	
	public int getScore(int index){
		if(index != 0 && index != 1)
			throw new IllegalArgumentException();
		return scores[index];
	}
}
