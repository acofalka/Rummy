package model;

public class Card {
	private Suit suit;
	private int rank;
	private int deckId;	// unique id of the card
	
	private final String[] rankNames = new String[]{
			"2", "3", "4", "5", "6", "7", "8", "9", "10", "Walet", "Dama", "Krol", "As", "Joker", "Joker"
	};
	
	public Card(int deckId){
		if (deckId < 1 || deckId > 54)
			throw new IllegalArgumentException();
		this.deckId = deckId;
		this.suit = deckIdToSuit(deckId);
		this.rank = deckIdToRank(deckId);
	}
	
	private Suit deckIdToSuit(int deckId){
		if (deckId < 1 || deckId > 54)
			throw new IllegalArgumentException();
		int suitId = deckId / 13;
		Suit suit = Suit.values()[suitId];
		return suit;
	}
	
	private int deckIdToRank(int deckId){
		if (deckId < 1 || deckId > 54)
			throw new IllegalArgumentException();
		if (deckId > 52)
			return deckId - 38;
		int rank = deckId % 13;
		return rank;
	}
	
	public String toString(){				// full card name
		String string =  getRankName() + " " + getSuitName();
		return string;
	}
	
	public String getSuitName(){		
		if (suit == Suit.CLUB) return "Trefl";
		else if (suit == Suit.DIAMOND) return "Karo";
		else if (suit == Suit.SPADE) return "Pik";
		else if (suit == Suit.HEART) return "Kier";
		else return "";
	}
	
	public String getRankName(){
		return rankNames[this.rank];
	}
}
