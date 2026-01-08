package model;

public class Card {
	private final CardSuit cardSuit;
	private final CardRank cardRank;

	private boolean faceUp;

	public Card(CardSuit cardSuit, CardRank cardRank) {
		this.cardSuit = cardSuit;
		this.cardRank = cardRank;

		this.faceUp = false;
	}

	public void flip() {
		this.faceUp = !this.faceUp;
	}

	public CardSuit getSuit() {
		return cardSuit;
	}

	public CardRank getRank() {
		return cardRank;
	}
}
