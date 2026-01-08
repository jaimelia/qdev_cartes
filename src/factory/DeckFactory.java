package factory;

import model.Deck;
import model.NormalDeck;
import model.SmallDeck;
import model.TestDeck;

public class DeckFactory {

	public static Deck makeDeck(DeckType type) {
		switch (type) {
			case SMALL -> {
				return new SmallDeck();
			}
			case NORMAL -> {
				return new NormalDeck();
			}
			case TEST -> {
				return new TestDeck();
			}
		}

		// fallback
		return new NormalDeck();
	}
}
