package model.cards;

public abstract class CardsCollection {
	protected boolean[] cards; // true - card with particular deckId is currently in the deck
	protected int numberOfCards;
	
	protected final int maxNumberOfCards = 54;
	
	public int getMaxNumberOfCards() {
		return maxNumberOfCards;
	}

	public boolean containsCard(int deckId){
		return cards[deckId];
	}
	
	public int getNumberOfCards(){
		return numberOfCards;
	}
	
	public String toString(){
		if (numberOfCards == 0)
			return "Brak kart w talii";
		StringBuilder sb = new StringBuilder("");
		for(int i = 0; i < 54; i++){
			if(cards[i]){
				Card card = new Card(i + 1);
				sb.append(card.toString());
				sb.append("\n");
			}
		}
		return sb.toString();
	}
}
