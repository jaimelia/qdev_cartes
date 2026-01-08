package builder;

import model.Deck;
import strategy.GameEvaluator;

public class Game {
	GameEvaluator ge;
	Deck deck;

	public Game(GameEvaluator ge, Deck deck) {
		this.ge = ge;
		this.deck = deck;
	}

	public GameEvaluator getGe() {
		return ge;
	}

	public Deck getDeck() {
		return deck;
	}
}
