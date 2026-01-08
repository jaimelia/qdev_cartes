package model;

public class NormalDeck extends Deck {
	public NormalDeck() {
		for (CardSuit cardSuit : CardSuit.values()) {
			for (CardRank cardRank : CardRank.values()) {
				addCard(new Card(cardSuit, cardRank));
			}
		}
	}
}
