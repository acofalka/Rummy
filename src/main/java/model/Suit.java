package model;

public enum Suit {
	CLUB(0),
	DIAMOND(1),
	SPADE(2),
	HEART(3),
	JOKER(4);
	
	private int id;
	
	private Suit(int id) {
        this.id = id;
    }
}
