package model;

public enum CardRank {
	ACE(13),
	KING(12),
	QUEEN(11),
	JACK(10),
	TEN(9),
	NINE(8),
	EIGHT(7),
	SEVEN(6),
	SIX(5),
	FIVE(4),
	FOUR(3),
	THREE(2),
	TWO(1);

	private final int rank;

	CardRank(int value) {
		this.rank = value;
	}

	public int getRank() {
		return rank;
	}
}
