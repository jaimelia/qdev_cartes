package model;

public enum CardSuit {
	CLUB(4),
	SPADE(3),
	HEART(2),
	DIAMOND(1);

	private final int suit;

	CardSuit(int value) {
		this.suit = value;
	}

	public int getSuit() {
		return suit;
	}
}
