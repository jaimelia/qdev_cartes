package model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private final List<Card> cards = new ArrayList<>();

	public void addCard(Card card) {
		this.cards.add(card);
	}

	public Card getCard(int idx) {
		return this.cards.get(idx);
	}

	public void removeCard(int idx) {
		this.cards.remove(idx);
	}
}
