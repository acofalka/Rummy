package model;

public class Card implements Comparable<Card>{
	private int deckId;	// unique id of the card
	private Suit suit;
	private int rank;	// 0-12: 2, 3, ..., 10, jack, queen, king, ace
	
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
	
	public Card(Suit suit, int rank){
		if(rank < 0 || rank > 14 || (rank > 12 && suit != Suit.JOKER))
			throw new IllegalArgumentException();
		this.deckId = toDeckId(suit, rank);
		this.suit = suit;
		this.rank = rank;
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
		if (deckId >= 52)
			return deckId - 39;
		int rank = deckId % 13;
		return rank;
	}
	
	private int toDeckId(Suit suit, int rank){
		if(rank < 0 || rank > 14 || (rank > 12 && suit != Suit.JOKER))
			throw new IllegalArgumentException();
		if(suit == Suit.JOKER)
			return rank + 39;
		int deckId = suit.getId() * 13 + rank;
		return deckId;
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
	
	public int getDeckId(){
		return deckId;
	}
	
	public Suit getSuit(){
		return suit;
	}
	
	public int getRank(){
		return rank;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (deckId != other.deckId)
			return false;
		return true;
	}

	public int compareTo(Card o) {
		return this.getDeckId() - o.getDeckId();
	}
}
