package model;

public class Player {
	private final Hand hand;
	private final String name;

	public Player(String name) {
		this.hand = new Hand();
		this.name = name;
	}

	public Hand getHand() {
		return hand;
	}

	public String getName() {
		return name;
	}
}